package dslr;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;

public class FixMavenRepoTest {
	private boolean actionInvoked = false;
	
	@Test
	public void testMavenRepoFixRules() throws Exception{
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		
		Request r = (Request) ds.createNewFact("defaultpkg", "ReqMvnBuild");
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
				
		        
		        final int returnCode = 1?has -Dmaven.repo.local=/alternate/repo/location;

		        ksession.retract(ksession.getFactHandle(a));
		    	ksession.insert(new GenericExecStatus(action.getActivity(), action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});
		
		ds.assertFactAndRun(r, pom);
	}
}
