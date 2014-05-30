package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.drools.KnowledgeBase;
import org.drools.builder.KnowledgeBuilder;
import org.drools.builder.KnowledgeBuilderError;
import org.drools.builder.KnowledgeBuilderFactory;
import org.drools.builder.ResourceType;
import org.drools.definition.KnowledgePackage;
import org.drools.definition.rule.Global;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

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
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatus;

public class DeploymentSession {
	private static final String QKEY_STATUS = "status";
	private static final String QKEY_SUBSTATUS = "substatus";
	private static final String QKEY_ACTIVITY = "activities";

	private StatefulKnowledgeSession ksession = null;
	private static final Logger log = Logger.getLogger(DeploymentSession.class);
	private static final Map<Class<? extends ActionFact>, ActionHandler> actionsMap = new HashMap<Class<? extends ActionFact>, ActionHandler>();

	public void init() throws Exception {

		log.setLevel(Level.ALL);

		initActions();

		initStatefulSession();

		// now insert environment facts
		initExecEnvironment();

		// log.debug("Original artifact is '" + originalArtifact + "'");
		//
		// if (originalArtifact.exists()){
		// initSession(originalArtifact, testDataPath);
		// } else {
		// final String msg = "Original artifact: file '" +
		// originalArtifact.getAbsolutePath() + "' doesn't exist!";
		// log.error(msg);
		// throw new RuntimeException(msg);
		// }

		log.info("Execution completed!");
	}

	private void initExecEnvironment() {
		String dataDir = System.getenv().get("OPENSHIFT_DATA_DIR");
		if (dataDir == null) {
			dataDir = "OpenShift\\datadir";
		}
		File f = new File(dataDir);
		f.mkdirs();
		log.info("Data dir: " + f.getAbsolutePath());
		ksession.insert(new DataDirRoot(f));
	}

	private static void initActions() {
		actionsMap.put(ExtractAction.class, new ExtractActionHandler());
		actionsMap.put(ExecAction.class, new ExecActionHandler());
		actionsMap.put(DetectEncodingAction.class,
				new DetectEncodingActionHandler());
		actionsMap.put(RunCommandRequestAction.class,
				new RunCommandRequestActionHandler());

	}

	public void run() throws Exception {
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
		// Collection<Object> objs = ksession.getObjects();

		// String buildStatus = "";
		// String testRunExecution = "";
		// String testRunVerification = "";
		// for (Object i : objs) {
		// if (i instanceof BuildSucceeded) {
		// buildStatus += " SUCCESS ";
		// } else if (i instanceof RunSucceeded) {
		// RunSucceeded r = (RunSucceeded) i;
		// if (r.getRun().getId().equals(R.id.TestActivity)) {
		// testRunExecution += " SUCCESS ";
		// }
		// } else if (i instanceof TestRunVerificationSucceeded) {
		// testRunVerification += " SUCCESS ";
		// }
		// }

		log.info("Execution completed with status: ");
		// log.info("     build status: "
		// + (buildStatus.isEmpty() ? " FAILURE " : buildStatus));
		// log.info("     test run execution: "
		// + (testRunExecution.isEmpty() ? " FAILURE " : testRunExecution));
		// log.info("     test run verification: "
		// + (testRunVerification.isEmpty() ? " FAILURE "
		// : testRunVerification));
	}

	private void executeActions(Collection<? extends ActionFact> actions)
			throws Exception {
		for (ActionFact i : actions) {
			ActionHandler h = actionsMap.get(i.getClass());

			if (h == null) {
				throw new RuntimeException("Can't find handler for action "
						+ i.getClass());
			}

			log.debug("Processing action: " + i);
			h.process(i, ksession);
		}
	}

	private void initStatefulSession() throws ZipException, IOException {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		URL t = DeploymentSession.class.getClassLoader().getResource(
				"basic_actions.drl");
		System.out.println("DRL is:" + t);

		if (t == null)
			throw new RuntimeException();

		log.debug("Looking for *.drl files");

		// String[] drlFiles =
		// Classpath.getClasspathFileNamesWithExtension(".drl");
		// Arrays.sort(drlFiles);
		// for (String resFileName : drlFiles) addClassPathEntry(kbuilder,
		// resFileName, ResourceType.DRL);
		addClassPathEntry(kbuilder, "a_definitions.drl", ResourceType.DRL);
		addClassPathEntry(kbuilder, "a_functions.drl", ResourceType.DRL);
		addClassPathEntry(kbuilder, "basic_actions.drl", ResourceType.DRL);
		addClassPathEntry(kbuilder, "preprocess.drl", ResourceType.DRL);

		KnowledgeBase kbase = kbuilder.newKnowledgeBase();
		debugTactType(kbase, "defaultpkg", "DeployFolder");
		debugTactType(kbase, "defaultpkg", "ReqDownloadHttp");

		String[] dslFiles = Classpath
				.getClasspathFileNamesWithExtension(".dsl");
		for (String resFileName : dslFiles)
			addClassPathEntry(kbuilder, resFileName, ResourceType.DSL);

		String[] dslrFiles = Classpath
				.getClasspathFileNamesWithExtension(".dslr");
		for (String resFileName : dslrFiles)
			addClassPathEntry(kbuilder, resFileName, ResourceType.DSLR);

		kbase = kbuilder.newKnowledgeBase();
		ksession = kbase.newStatefulKnowledgeSession();

		// ksession.addEventListener(new DebugAgendaEventListener());
		// ksession.addEventListener(new DebugWorkingMemoryEventListener());
		ksession.addEventListener(new AgendaDebugListener());
		initGlobals(kbase, ksession);
	}

	private void initGlobals(KnowledgeBase kbase,
			StatefulKnowledgeSession ksession2) {
		for (KnowledgePackage pkg : kbase.getKnowledgePackages()) {
			Collection<Global> globals = pkg.getGlobalVariables();
			for (Global g : globals) {
				if (g.getClass().isAssignableFrom(String.class)) {
					ksession2.setGlobal(g.getName(), (String) g.getName());
				}
			}
		}
	}

	private void debugTactType(KnowledgeBase kbase, String pkg, String name) {
		FactType ft = kbase.getFactType(pkg, name);
		debugTactType(ft);
	}

	private void debugTactType(FactType ft) {
		for (Constructor<?> i : ft.getFactClass().getConstructors()) {
			System.out.println(">> ctr >> " + i);
		}
	}

	private void addClassPathEntry(KnowledgeBuilder kbuilder,
			String resFileName, ResourceType type) {
		if (resFileName.indexOf('/') == -1) {
			System.out.println("[+] Found classpath resource: " + resFileName);

			try {
				kbuilder.add(ResourceFactory.newClassPathResource(resFileName),
						type);
			} catch (Throwable e) {
				e.printStackTrace();
				throw new RuntimeException("error", e);
			}
			if (kbuilder.hasErrors()) {
				for (KnowledgeBuilderError i : kbuilder.getErrors()) {
					System.out.println(i);
				}
				throw new RuntimeException("kbuilder has errors!");
			}
		} else {
			System.out.println("[-] Ignoring classpath resource: "
					+ resFileName);
		}
	}

	public void dispose() {
		if (ksession != null) {
			ksession.dispose();
			ksession = null;
		}
	}

	public void reset() throws Exception {
		this.dispose();
		this.init();
	}

	public void assertFactAndRun(Object... f) throws Exception {
		for (Object i : f) {
			ksession.insert(i);
		}

		this.run();
	}

	public void assertFact(Object f) {
		ksession.insert(f);
	}

	public static class QResult {
		public RequestStatus mainStatus;
		public List<RequestSubstatus> substatuses;
		public List<Activity> activities;

		public QResult(RequestStatus mainStatus,
				List<RequestSubstatus> substatuses, List<Activity> activities) {
			super();
			this.mainStatus = mainStatus;
			this.substatuses = substatuses;
			this.activities = activities;
		}
	}

	public List<QResult> getRequestStatus(long reqRefId) {
		QueryResults results = ksession.getQueryResults(
				"RequestStatus for request refId", reqRefId);
		return parseQResults(results);
	}

	private List<QResult> parseQResults(QueryResults results) {
		final List<QResult> parsedResults = new LinkedList<QResult>();

		Iterator<QueryResultsRow> it = results.iterator();
		if (it.hasNext()) {
			while (it.hasNext()) {
				QueryResultsRow row = it.next();
				RequestStatus status = (RequestStatus) row.get(QKEY_STATUS);
				List<RequestSubstatus> substatus = (List<RequestSubstatus>) row
						.get(QKEY_SUBSTATUS);
				List<Activity> activities = (List<Activity>) row
						.get(QKEY_ACTIVITY);
				QResult r = new QResult(status, substatus, activities);
				parsedResults.add(r);
			}

		} else {
			log.warn("No results found for request.");
		}

		return parsedResults;
	}

	public List<QResult> getRequestStatus(RequestFact req) {
		QueryResults results = ksession.getQueryResults(
				"RequestStatus for request", req);
		return parseQResults(results);
	}
}
