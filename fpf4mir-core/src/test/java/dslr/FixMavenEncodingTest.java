package dslr;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

import org.codehaus.jackson.map.ObjectMapper;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Alias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl.UserActionRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFailed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSuspended;

public class FixMavenEncodingTest {
	
	@Test
	public void testMavenEncFixRules() throws Exception{
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
				
				ExecAction action = (ExecAction) a;
				final File workingDir = action.getWorkingDir();
				
				// final File fileIn = new File(workingDir, UUID.randomUUID().toString() + ".in");
				final File fileOut;
				final File fileErr = new File(workingDir, "empty");
				
				final int returnCode;
				
				boolean hasMvnEncFlag = false;
				for (String i : action.getExecCommand().getArgsList()){
					if (i.startsWith("-Dproject.build.sourceEncoding=")){
						hasMvnEncFlag = true;
						break;
					}
				}
				
		        if (hasMvnEncFlag){
		        	returnCode = 0;
		        	fileOut = new File(workingDir, "empty");
		        } else {
		        	returnCode = 1;
		        	fileOut = new File(workingDir, "unmappable_character.out");
		        }

		        ksession.retract(ksession.getFactHandle(a));
		    	ksession.insert(new GenericExecStatus(action.getActivity(), action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});
		
		ds.assertFactAndRun(r, pom);
		
		List<QResult> rstatus = ds.getRequestStatus(rId); //FIXME: getRequestStatus(r) doesn't work?!
		Assert.assertEquals(1, rstatus.size());
		
		RequestStatus rs = rstatus.get(0).mainStatus;
		Assert.assertTrue(rs.toString(), rs instanceof RequestSuspended);
		
		// TODO: check user actions here
		
		List<Object> rsrfs = ds.getRequestStatusRelatedFacts(rs);
		Assert.assertTrue(rsrfs.size() > 0);
		
		UserAction ua = null;
		
		for (Object i : rsrfs){
			System.out.println(i.toString());
			if (i instanceof Alias && ((Alias)i).getRefObject() instanceof UserActionRef){
				UserActionRef ref = (UserActionRef)((Alias)i).getRefObject();
				if (ua == null){
					ua = ref.getRefObject();
				} else {
					Assert.fail("Expected only one action");
				}
			}
		}
		
		Assert.assertNotNull(ua);
		ActivityRelatedFact fact = (ActivityRelatedFact)ds.newFact(new ObjectMapper().readTree("{\"class\":\"defaultpkg.UsrUseEncoding\", \"encoding\":\"cp1251\"}"));
		fact.setActivity(ua.getActivity());
		ds.setFactHandled(ua);
		ds.assertFactAndRun(fact);
		
		rstatus = ds.getRequestStatus(rId); //FIXME: getRequestStatus(r) doesn't work?!
		Assert.assertEquals(1, rstatus.size());
		
		rs = rstatus.get(0).mainStatus;
		Assert.assertTrue(rs.toString(), rs instanceof RequestSucceeded);
	}

}
