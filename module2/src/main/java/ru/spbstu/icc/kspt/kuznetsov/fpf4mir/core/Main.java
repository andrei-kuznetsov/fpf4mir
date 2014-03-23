package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.ZipException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.DetectEncodingAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ExtractAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.RunCommandRequestAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.DetectEncodingActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ExecActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ExtractActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.RunCommandRequestActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir.Dataset;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir.ScratchDirIn;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mirex.CallFormat_MIREX_AudioChordEstimation;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.RunDatasetIn;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.RunSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.TestRunVerificationSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewBuild;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewRun;

public class Main {
	private StatefulKnowledgeSession ksession = null;
	private static final Logger log = Logger.getLogger(Main.class);
	private static final Map<Class<? extends ActionFact>, ActionHandler> actionsMap = new HashMap<Class<? extends ActionFact>, ActionHandler>();
	
	public static void main(String[] args) throws Exception {
		log.setLevel(Level.ALL);

		initActions();
		
		Main m = new Main();
		m.initStatefulSession();
		
		
		if (args.length < 2){
			args = new String[] {
					"/home/andrei/OpenShift/datadir/cea1c11a-ff7b-4f6f-8974-d327f3ec544b/chordest-master.zip",
					"/media/andrei/WORK/phd/oma/test"};
			log.warn("Wrong invokation format");
			log.warn("Expected format is: 'main <originalArtifact> <dataset>'");
		}
		
		log.debug("Original artifact is '" + args[0] + "'");
		
		File originalArtifact = new File(args[0]);
		
		if (originalArtifact.exists()){
			m.initSession(originalArtifact, args[1]);
			m.run();
		} else {
			final String msg = "Original artifact: file '" + originalArtifact.getAbsolutePath() + "' doesn't exist!";
			log.error(msg);
			throw new RuntimeException(msg);
		}
		
		log.info("Execution completed!");
	}

	private static void initActions() {
		actionsMap.put(ExtractAction.class, new ExtractActionHandler());
		actionsMap.put(ExecAction.class, new ExecActionHandler());
		actionsMap.put(DetectEncodingAction.class, new DetectEncodingActionHandler());
		actionsMap.put(RunCommandRequestAction.class, new RunCommandRequestActionHandler());
		
	}

	private void run() throws Exception {
		boolean doContinue = false;
		do {
			ksession.fireAllRules();
			Collection actions = ksession.getObjects(new ObjectFilter() {
				@Override
				public boolean accept(Object object) {
					return (object instanceof ActionFact);
				}
			});
			 
			if (actions.size() > 0) {
				executeActions(actions);
				doContinue = true;
				log.debug("Continue execution...");
			} else {
				doContinue = false;
			}
			
		} while (doContinue);
		
		// Analyze results
		Collection<Object> objs = ksession.getObjects();
		
		String buildStatus = "";
		String testRunExecution = "";
		String testRunVerification = "";
		for (Object i : objs){
			if (i instanceof BuildSucceeded){
				buildStatus += " SUCCESS "; 
			} else if (i instanceof RunSucceeded) {
				RunSucceeded r = (RunSucceeded) i;
				if (r.getRun().getId().equals(R.id.TestActivity)){
					testRunExecution += " SUCCESS ";
				}
			} else if (i instanceof TestRunVerificationSucceeded) {
				testRunVerification += " SUCCESS "; 
			}
		}
		
		log.info("Execution completed with status: ");
		log.info("     build status: " + (buildStatus.isEmpty()?" FAILURE ":buildStatus));
		log.info("     test run execution: " + (testRunExecution.isEmpty()?" FAILURE ":testRunExecution));
		log.info("     test run verification: " + (testRunVerification.isEmpty()?" FAILURE ":testRunVerification));
	}

	private void executeActions(Collection<? extends ActionFact> actions) throws Exception {
		for (ActionFact i : actions){
			ActionHandler h = actionsMap.get(i.getClass());
			
			if (h == null){
				throw new RuntimeException("Can't find handler for action " + i.getClass());
			}

			log.debug("Processing action: " + i);
			h.process(i, ksession);
		}
	}

	private void initSession(File originalArtifact, String dataset) {
		ReqNewRun rr = new ReqNewRun(true);
		
		ksession.insert(new ReqNewBuild());
		//ksession.insert(new ReqNewRun());
		
		ksession.insert(new FileArtifact(R.id.OriginalArtifact, originalArtifact));
		ksession.insert(new DataDirRoot(originalArtifact.getParentFile()));
		ksession.insert(new CallFormat_MIREX_AudioChordEstimation());
		ksession.insert(rr);
		ksession.insert(new Dataset("test", new File(dataset)));
		ksession.insert(new RunDatasetIn(rr, "test"));
		ksession.insert(new ScratchDirIn(null, rr));
	}

	private void initStatefulSession() throws ZipException, IOException {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory.newKnowledgeBuilder();
		
		URL t = Main.class.getClassLoader().getResource("basic_actions.drl");
		System.out.println("DRL is:" + t);
		
		if (t == null) throw new RuntimeException();
		
		log.debug("Looking for *.drl files");
		for (String resFileName : Classpath.getClasspathFileNamesWithExtension(".drl")){
			if (resFileName.indexOf('/') == -1){
				System.out.println("[+] Found classpath resource: " + resFileName);
				kbuilder.add(ResourceFactory.newClassPathResource(resFileName), ResourceType.DRL);
				if (kbuilder.hasErrors()){
					for (KnowledgeBuilderError i : kbuilder.getErrors()){
						System.out.println(i);
					}
					throw new RuntimeException("kbuilder has errors!");
				}
			} else {
				System.out.println("[-] Ignoring classpath resource: " + resFileName);
			}
		}
		
        KnowledgeBase kbase = kbuilder.newKnowledgeBase();
        ksession = kbase.newStatefulKnowledgeSession();
        
//        ksession.addEventListener(new DebugAgendaEventListener());
//        ksession.addEventListener(new DebugWorkingMemoryEventListener());
        ksession.addEventListener(new AgendaDebugListener());
	}
}
