package drl;

import static org.junit.Assert.assertTrue;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import utils.AgendaListener;
import utils.DrlObjectsUtils;

public class DrlTestRunVerify {

	private static final String DRL_FILENAME = "testrun_verify.drl";

	@Test
	public void mirexChEstCountRuleTest_ok() throws URISyntaxException  {
        StatefulKnowledgeSession ksession = prepareKSession("/oma", "/oma_res_chest_ok");
        
        AgendaListener al = new AgendaListener();
        ksession.addEventListener(al);
        
        ksession.fireAllRules();
        
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultsFormat__CallFormat_MIREX_AudioChordEstimation"));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultsFNames__CallFormat_MIREX_AudioChordEstimation"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
        System.out.println(omap);
//        assertTrue(omap.containsKey(TestRunVerification_FileNamesOk.class));
//        assertTrue(omap.containsKey(TestRunVerification_FileFormatOk.class));
//        assertTrue(omap.containsKey(TestRunVerificationSucceeded.class));
        
        ksession.dispose();
	}

	@Test
	public void mirexChEstCountRuleTest_fnnok() throws URISyntaxException  {
        StatefulKnowledgeSession ksession = prepareKSession("/oma", "/oma_res_chest_fnnok");
        
        AgendaListener al = new AgendaListener();
        ksession.addEventListener(al);
        
        ksession.fireAllRules();
        
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultsFormat__CallFormat_MIREX_AudioChordEstimation"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
//        assertFalse(omap.containsKey(TestRunVerification_FileNamesOk.class));
//        assertTrue(omap.containsKey(TestRunVerification_FileFormatOk.class));
//        assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));
//        assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));
        
        ksession.dispose();
	}

	@Test
	public void mirexChEstCountRuleTest_fmtnok() throws URISyntaxException  {
        StatefulKnowledgeSession ksession = prepareKSession("/oma", "/oma_res_chest_fmtnok");
        
        AgendaListener al = new AgendaListener();
        ksession.addEventListener(al);
        
        ksession.fireAllRules();
        
        System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
        assertTrue(al.getFiredRules().contains("TestRun_Verify_ResultsFNames__CallFormat_MIREX_AudioChordEstimation"));
        
        Collection<Object> objects = ksession.getObjects();
        Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
//        assertTrue(omap.containsKey(TestRunVerification_FileNamesOk.class));
//        assertFalse(omap.containsKey(TestRunVerification_FileFormatOk.class));
//        assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));
        
        ksession.dispose();
	}

	private StatefulKnowledgeSession prepareKSession(String srcDir, String resDir)
			throws URISyntaxException {
		StatefulKnowledgeSession ksession = DrlObjectsUtils.prepareStatefullSession(DRL_FILENAME);
        
//		ReqRun rr = new ReqRun();
//		Dataset dataset = new Dataset(null, PathUtils.getTestResourceDir(srcDir).getAbsolutePath(), "");
//		dataset.setName("test");
		
        //RunDatasetIn src = new RunDatasetIn(rr, dataset.getName());
        Activity testRun = null; //TODO: (RunActivity) new RunActivity().reset(R.id.TestActivity, new Date(), rr);
//		Dataset_FileArtifactList dsal = new Dataset_FileArtifactList(testRun, dataset, "*.wav", null);
        ActionStatus status = new GenericExecStatus(testRun, null, 0, null, null);
//        ResultDir4Run res = new ResultDir4Run();
//        res.reset(testRun, PathUtils.getTestResourceDir(resDir).getAbsolutePath(), "");

        ksession.insert(testRun);
        //ksession.insert(src);
        ksession.insert(status);
//        ksession.insert(dsal);
//        ksession.insert(new Dataset_FileArtifactList4Run(testRun, dsal));
//        ksession.insert(res);
        //ksession.insert(new CallFormat_MIREX_AudioChordEstimation());
		return ksession;
	}

}
