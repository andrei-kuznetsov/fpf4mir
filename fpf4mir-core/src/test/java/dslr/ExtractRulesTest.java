package dslr;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Alias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;

public class ExtractRulesTest {
	@Test
	public void testArtifactNamePreserved() throws Exception{
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		
		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {

			@Override
			public void process(Action a, StatefulKnowledgeSession ksession)
					throws Exception {
				System.out.println("Action invoked: " + a);

				ExecAction action = (ExecAction) a;
				final File workingDir = action.getWorkingDir();

				// final File fileIn = new File(workingDir,
				// UUID.randomUUID().toString() + ".in");
				final File fileOut = new File(workingDir, "empty");
				final File fileErr = new File(workingDir, "empty");

				int returnCode = -1;
				if (action.getCommand().equals("jar") &&
						action.getArguments().get(0).equals("xf") &&
						action.getArguments().get(1).endsWith("src/test/resources/c1.zip")){
					returnCode = 0;
				}
				
				ksession.retract(ksession.getFactHandle(a));
				ksession.insert(new GenericExecStatus(action.getActivity(),
						action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});
		

		Request r = ds.createNewRequest("defaultpkg", "ReqExtract");
		
		GenericFileArtifact f = new GenericFileArtifact(ActivityBase.USER, "", new File("src/test/resources/c1.zip").getAbsolutePath());
		f.setName("test name");
		ds.attachDn(r, f);
		
		ds.assertFactAndRun(r, f);
		
		RequestStatus status = ds.getRequestMainStatus(r);
		Assert.assertTrue(status.getMessage(), status instanceof RequestSucceeded);
		
		List<Object> rsv = ds.getRequestStatusRelatedFacts(status);
		Assert.assertEquals(1, rsv.size());
		
		boolean found = false;
		for (Object i : rsv){
			if (i instanceof Alias){
				Assert.assertEquals(f.getName(), ((Alias)i).getName());
				found = true;
				break;
			}
		}
		
		Assert.assertTrue(found);
	}
}
