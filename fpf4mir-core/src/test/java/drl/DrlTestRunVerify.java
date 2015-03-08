package drl;

import static org.junit.Assert.assertTrue;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.drools.runtime.StatefulKnowledgeSession;
import org.junit.Assert;
import org.junit.Test;

import dslr.DbgDeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericDownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericArtifactRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericExecutableFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;
import utils.AgendaListener;
import utils.DrlObjectsUtils;
import utils.PathUtils;
import utils.TestDownloadActionHandlerImpl;

public class DrlTestRunVerify {

	private static final String DRL_FILENAME = "testrun_verify.drl";

	@Test
	public void mirexChEstCountRuleTest_ok() throws Exception {
		final String EXEC_JAR_FILE = PathUtils.getTestResourceFile("/empty.jar").getAbsolutePath();
		
		final DbgDeploymentSession ds = new DbgDeploymentSession();
		ds.init();
		ds.setActionHandler(
				GenericDownloadAction.class,
				new TestDownloadActionHandlerImpl(
						new TestDownloadActionHandlerImpl.DlResult[] { new TestDownloadActionHandlerImpl.DlResult(
								"http://192.168.1.5/oma.zip", 200, new File(
										"src/test/resources/c1.zip")) }));

		ds.setActionHandler(GenericExecAction.class, new ActionHandler() {
			private int unzipped = 0;
			private int ut_run = 0;
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
					unzipped++;
					Assert.assertTrue(new File(action.getWorkingDir(), "file01.wav").createNewFile());
					Assert.assertTrue(new File(action.getWorkingDir(), "file02.wav").createNewFile());
					Assert.assertEquals(1, unzipped);
				} else if (action.getCommand().equals("java") && 
						action.getArguments().contains(EXEC_JAR_FILE)){
					returnCode = 0;
					
					int idx = action.getArguments().indexOf(EXEC_JAR_FILE);
					
					File targetDir = new File(action.getArguments().get(idx + 3));
					checkFileListContentsAndCopy(action.getArguments().get(idx + 1), targetDir);
					
					ut_run++;
					Assert.assertEquals(1, ut_run);
				}
				
				ksession.retract(ksession.getFactHandle(a));
				ksession.insert(new GenericExecStatus(action.getActivity(),
						action.getExecCommand(), returnCode, fileOut, fileErr));

			}
		});

		RequestStatus rs;
		Request r = ds.createNewRequest("defaultpkg", "ReqUTMirexAudChEst");
		
		GenericExecutableFileArtifact e = new GenericExecutableFileArtifact(ActivityBase.USER, "", EXEC_JAR_FILE);
		ds.attachDn(r, e);
		
		ActivityRelatedFact fmt = ds.createNewARF("defaultpkg", "RunFormat_Mirex_Aud_ChEst");
		ds.attachDn(r, fmt);
		
		ds.assertFactAndRun(r, e, fmt);

		/*
		 * AgendaListener al = new AgendaListener();
		 * ksession.addEventListener(al);
		 * 
		 * ksession.fireAllRules();
		 * 
		 * System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
		 * assertTrue(al.getFiredRules().contains(
		 * "TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
		 * assertTrue(al.getFiredRules().contains(
		 * "TestRun_Verify_ResultsFormat__CallFormat_MIREX_AudioChordEstimation"
		 * )); assertTrue(al.getFiredRules().contains(
		 * "TestRun_Verify_ResultsFNames__CallFormat_MIREX_AudioChordEstimation"
		 * ));
		 * 
		 * Collection<Object> objects = ksession.getObjects(); Map<Class, List>
		 * omap = DrlObjectsUtils.convertToMap(objects);
		 * System.out.println(omap); //
		 * assertTrue(omap.containsKey(TestRunVerification_FileNamesOk.class));
		 * //
		 * assertTrue(omap.containsKey(TestRunVerification_FileFormatOk.class));
		 * // assertTrue(omap.containsKey(TestRunVerificationSucceeded.class));
		 */

		rs = ds.getRequestMainStatus(r);
		Assert.assertTrue(rs.toString(), rs instanceof RequestSucceeded);
	}

	protected void checkFileListContentsAndCopy(String fn, File targetDir) throws IOException, URISyntaxException {
		BufferedReader br = new BufferedReader(new FileReader(fn));
		String ln;
		
		int lncnt = 0;
		while ((ln = br.readLine()) != null){
			if (ln.isEmpty()) continue;
			lncnt++;
			Assert.assertTrue(ln, ln.endsWith("file0" + lncnt + ".wav"));
			File src = PathUtils.getTestResourceFile("/oma_res_chest_ok/file0" + lncnt + ".wav.txt");
			FileUtils.copyFile(src, new File(targetDir, src.getName()+".out"));
		}
		
		Assert.assertEquals(2, lncnt);
	}

	@Test
	public void mirexChEstCountRuleTest_fnnok() throws URISyntaxException {
		StatefulKnowledgeSession ksession = prepareKSession("/oma",
				"/oma_res_chest_fnnok");

		AgendaListener al = new AgendaListener();
		ksession.addEventListener(al);

		ksession.fireAllRules();

		System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
		assertTrue(al
				.getFiredRules()
				.contains(
						"TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
		assertTrue(al
				.getFiredRules()
				.contains(
						"TestRun_Verify_ResultsFormat__CallFormat_MIREX_AudioChordEstimation"));

		Collection<Object> objects = ksession.getObjects();
		Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
		// assertFalse(omap.containsKey(TestRunVerification_FileNamesOk.class));
		// assertTrue(omap.containsKey(TestRunVerification_FileFormatOk.class));
		// assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));
		// assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));

		ksession.dispose();
	}

	@Test
	public void mirexChEstCountRuleTest_fmtnok() throws URISyntaxException {
		StatefulKnowledgeSession ksession = prepareKSession("/oma",
				"/oma_res_chest_fmtnok");

		AgendaListener al = new AgendaListener();
		ksession.addEventListener(al);

		ksession.fireAllRules();

		System.out.println(Arrays.deepToString(al.getFiredRules().toArray()));
		assertTrue(al
				.getFiredRules()
				.contains(
						"TestRun_Verify_ResultList__CallFormat_MIREX_AudioChordEstimation"));
		assertTrue(al
				.getFiredRules()
				.contains(
						"TestRun_Verify_ResultsFNames__CallFormat_MIREX_AudioChordEstimation"));

		Collection<Object> objects = ksession.getObjects();
		Map<Class, List> omap = DrlObjectsUtils.convertToMap(objects);
		// assertTrue(omap.containsKey(TestRunVerification_FileNamesOk.class));
		// assertFalse(omap.containsKey(TestRunVerification_FileFormatOk.class));
		// assertFalse(omap.containsKey(TestRunVerificationSucceeded.class));

		ksession.dispose();
	}

	private StatefulKnowledgeSession prepareKSession(String srcDir,
			String resDir) throws URISyntaxException {
		StatefulKnowledgeSession ksession = DrlObjectsUtils
				.prepareStatefullSession(DRL_FILENAME);

		// ReqRun rr = new ReqRun();
		// Dataset dataset = new Dataset(null,
		// PathUtils.getTestResourceDir(srcDir).getAbsolutePath(), "");
		// dataset.setName("test");

		// RunDatasetIn src = new RunDatasetIn(rr, dataset.getName());
		Activity testRun = null; // TODO: (RunActivity) new
									// RunActivity().reset(R.id.TestActivity,
									// new Date(), rr);
		// Dataset_FileArtifactList dsal = new Dataset_FileArtifactList(testRun,
		// dataset, "*.wav", null);
		ActionStatus status = new GenericExecStatus(testRun, null, 0, null,
				null);
		// ResultDir4Run res = new ResultDir4Run();
		// res.reset(testRun,
		// PathUtils.getTestResourceDir(resDir).getAbsolutePath(), "");

		ksession.insert(testRun);
		// ksession.insert(src);
		ksession.insert(status);
		// ksession.insert(dsal);
		// ksession.insert(new Dataset_FileArtifactList4Run(testRun, dsal));
		// ksession.insert(res);
		// ksession.insert(new CallFormat_MIREX_AudioChordEstimation());
		return ksession;
	}

}
