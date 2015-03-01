package dslr;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
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
	private boolean actionInvoked = false;
	
	@Test
	public void testMavenRepoFixRules() throws Exception{
		final long rId = 1l;
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		
		Request r = (Request) ds.createNewFact("defaultpkg", "ReqMvnBuild");
		r.setRefId(rId);
		r.setActivity(ActivityBase.USER);
		
		FileArtifact pom = (FileArtifact) ds.createNewFact("defaultpkg", "BuildFile");
		pom.setActivity(ActivityBase.USER);
		pom.setFileName("src/test/resources/mvn/pom.xml");
		
		ds.attach(r, pom);
		
		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {
			
			@Override
			public void process(Action a, StatefulKnowledgeSession ksession)
					throws Exception {
				System.out.println("Action invoked: " + a);
				actionInvoked = true;
				
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
		
		List<QResult> rstatus = ds.getRequestStatus(rId); //FIXME: getRequestStatus(r) doesn't work?!
		Assert.assertEquals(1, rstatus.size());
		
		final RequestStatus rs = rstatus.get(0).mainStatus;
		Assert.assertTrue(rs.toString(), rs instanceof RequestSucceeded);
	}

	@Test
	public void testMavenRepoFixRules_Unrecoverable() throws Exception{
		final long rId = 1l;
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		
		Request r = (Request) ds.createNewFact("defaultpkg", "ReqMvnBuild");
		r.setRefId(rId);
		r.setActivity(ActivityBase.USER);
		
		FileArtifact pom = (FileArtifact) ds.createNewFact("defaultpkg", "BuildFile");
		pom.setActivity(ActivityBase.USER);
		pom.setFileName("src/test/resources/mvn/pom.xml");
		
		ds.attach(r, pom);
		
		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {
			
			@Override
			public void process(Action a, StatefulKnowledgeSession ksession)
					throws Exception {
				System.out.println("Action invoked: " + a);
				actionInvoked = true;
				
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
		
		List<QResult> rstatus = ds.getRequestStatus(rId); //FIXME: getRequestStatus(r) doesn't work?!
		Assert.assertEquals(1, rstatus.size());
		
		final RequestStatus rs = rstatus.get(0).mainStatus;
		Assert.assertTrue(rs.toString(), rs instanceof RequestFailed);
	}
}
