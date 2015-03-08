package dslr;

import java.io.File;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFailed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;

public class FixMavenRepoTest {
	
	@Test
	public void testMavenRepoFixRules() throws Exception{
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		Request r = (Request) ds.createNewRequest("defaultpkg", "ReqMvnBuild");
		
		FileArtifact pom = (FileArtifact) ds.createNewFact("defaultpkg", "BuildFile");
		pom.setActivity(ActivityBase.USER);
		pom.setFileName("src/test/resources/mvn/pom.xml");
		
		ds.attachDn(r, pom);
		
		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {
			
			@Override
			public void process(Action a, StatefulKnowledgeSession ksession)
					throws Exception {
				System.out.println("Action invoked: " + a);
				
				ExecAction action = (ExecAction) a;
				final File workingDir = action.getWorkingDir();
				
				// final File fileIn = new File(workingDir, UUID.randomUUID().toString() + ".in");
				final File fileOut;
				final File fileErr = new File(workingDir, "empty");
				
				final int returnCode;
				
				boolean hasMvnRepoFlag = false;
				for (String i : action.getExecCommand().getArgsList()){
					if (i.startsWith("-Dmaven.repo.local")){
						hasMvnRepoFlag = true;
						break;
					}
				}
				
		        if (hasMvnRepoFlag){
		        	returnCode = 0;
		        	fileOut = new File(workingDir, "empty");
		        } else {
		        	returnCode = 1;
		        	fileOut = new File(workingDir, "couldnot_create_repo.out");
		        }

		        ksession.retract(ksession.getFactHandle(a));
		    	ksession.insert(new GenericExecStatus(action.getActivity(), action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});
		
		ds.assertFactAndRun(r, pom);

		final RequestStatus rs = ds.getRequestMainStatus(r);
		Assert.assertTrue(rs.toString(), rs instanceof RequestSucceeded);
	}

	@Test
	public void testMavenRepoFixRules_Unrecoverable() throws Exception{
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		Request r = ds.createNewRequest("defaultpkg", "ReqMvnBuild");
		
		FileArtifact pom = (FileArtifact) ds.createNewFact("defaultpkg", "BuildFile");
		pom.setActivity(ActivityBase.USER);
		pom.setFileName("src/test/resources/mvn/pom.xml");
		
		ds.attachDn(r, pom);
		
		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {
			
			@Override
			public void process(Action a, StatefulKnowledgeSession ksession)
					throws Exception {
				System.out.println("Action invoked: " + a);
				
				ExecAction action = (ExecAction) a;
				final File workingDir = action.getWorkingDir();
				
				// final File fileIn = new File(workingDir, UUID.randomUUID().toString() + ".in");
				final File fileOut = new File(workingDir, "couldnot_create_repo.out");
				final File fileErr = new File(workingDir, "empty");
				
				final int returnCode = 1;

		        ksession.retract(ksession.getFactHandle(a));
		    	ksession.insert(new GenericExecStatus(action.getActivity(), action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});
		
		ds.assertFactAndRun(r, pom);
		
		final RequestStatus rs = ds.getRequestMainStatus(r);
		Assert.assertTrue(rs.toString(), rs instanceof RequestFailed);
	}
}
