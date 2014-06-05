package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.net.URL;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
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
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.DetectEncodingAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.DetectEncodingActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ExecActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestStatusRelatedFact;

public class DeploymentSession {
	private static final String QKEY_ACTIVITY_OBJECT = "$object";

	public static enum EXECUTION_STATE {
		RUNNING, DONE, WAITING_FOR_USER
	};

	private static final String QKEY_STATUS = "$rstatus";
	private static final String QKEY_SUBSTATUS = "substatus";
	private static final String QKEY_ACTIVITY = "activities";
	private static final String QKEY_EXTRAS = "extras";

	private StatefulKnowledgeSession ksession = null;
	private static final Logger log = Logger.getLogger(DeploymentSession.class);
	private static final Map<Class<? extends ActionFact>, ActionHandler> actionsMap = new HashMap<Class<? extends ActionFact>, ActionHandler>();

	private EXECUTION_STATE state = EXECUTION_STATE.DONE;

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
		ksession.insert(new DataDirRoot(Activity.USER, f.getAbsolutePath(), ""));
	}

	private static void initActions() {
		actionsMap.put(ExecAction.class, new ExecActionHandler());
		actionsMap.put(DetectEncodingAction.class,
				new DetectEncodingActionHandler());

	}

	public void run() throws Exception {
		boolean doContinue = false;
		do {
			try {
				ksession.fireAllRules();
				Collection actions = ksession.getObjects(new ObjectFilter() {
					@Override
					public boolean accept(Object object) {
						return (object instanceof ActionFact);
					}
				});

				state = executeActions(actions);

				switch (state) {
				case RUNNING:
					doContinue = true;
					log.debug("Continue execution...");
					break;
				case DONE:
					doContinue = false;
					log.debug("Done.");
					break;
				case WAITING_FOR_USER:
					doContinue = false;
					log.info("Waiting for user action...");
				}
			} catch (Exception e) {
				log.error("KB run exception", e);
				throw e;
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

		log.info("Execution completed with status: " + state);
		// log.info("     build status: "
		// + (buildStatus.isEmpty() ? " FAILURE " : buildStatus));
		// log.info("     test run execution: "
		// + (testRunExecution.isEmpty() ? " FAILURE " : testRunExecution));
		// log.info("     test run verification: "
		// + (testRunVerification.isEmpty() ? " FAILURE "
		// : testRunVerification));
	}

	private EXECUTION_STATE executeActions(
			Collection<? extends ActionFact> actions) throws Exception {

		final EXECUTION_STATE ret;

		boolean hasUserAction = false;
		boolean hasNonUserAction = false;

		for (ActionFact i : actions) {
			if (i instanceof UserAction) {
				log.info("Waiting for user action: " + i);
				hasUserAction = true;
			} else {
				ActionHandler h = actionsMap.get(i.getClass());

				if (h == null) {
					throw new RuntimeException("Can't find handler for action "
							+ i.getClass());
				}

				log.debug("Processing action: " + i);
				h.process(i, ksession);
				hasNonUserAction = true;
			}
		}

		if (hasNonUserAction)
			ret = EXECUTION_STATE.RUNNING;
		else if (hasUserAction)
			ret = EXECUTION_STATE.WAITING_FOR_USER;
		else
			ret = EXECUTION_STATE.DONE;

		return ret;
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
		addClassPathEntry(kbuilder, "basic_queries.drl", ResourceType.DRL);
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
		public List<RequestStatusRelatedFact> extras;

		public QResult(RequestStatus mainStatus,
				List<RequestSubstatus> substatuses, List<Activity> activities,
				List<RequestStatusRelatedFact> extras) {
			super();
			this.mainStatus = mainStatus;
			this.substatuses = substatuses;
			this.activities = activities;
			this.extras = extras;
		}

		public RequestStatus getMainStatus() {
			return mainStatus;
		}

		public List<RequestSubstatus> getSubstatuses() {
			return substatuses;
		}

		public List<Activity> getActivities() {
			return activities;
		}

		public List<RequestStatusRelatedFact> getExtras() {
			return extras;
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

				List<RequestStatusRelatedFact> extras = (List<RequestStatusRelatedFact>) row
						.get(QKEY_EXTRAS);

				QResult r = new QResult(status, substatus, activities, extras);
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

	private <T> T getTypedObjectById(long id, Class<T> klass) {
		final String simpleName = klass.getSimpleName();

		QueryResults results = ksession.getQueryResults(simpleName
				+ " for refId", id);
		Iterator<QueryResultsRow> it = results.iterator();
		if (it.hasNext()) {
			QueryResultsRow r = it.next();
			if (it.hasNext())
				log.warn("More than one " + simpleName + " found for refId="
						+ id);

			T ua = (T) r.get(QKEY_ACTIVITY_OBJECT);
			return ua;
		} else {
			return null;
		}
	}

	public UserAction getUserAction(long id) {
		return getTypedObjectById(id, UserAction.class);
	}

	public Activity getActivity(long id) {
		return getTypedObjectById(id, Activity.class);
	}

	public Object newFact(JsonNode fact) throws InstantiationException,
			IllegalAccessException {
		final String className = fact.get("class").asText();
		final String pkg = className.substring(0, className.lastIndexOf('.'));
		final String cn = className.substring(className.lastIndexOf('.') + 1);
		FactType ftype = ksession.getKnowledgeBase().getFactType(pkg, cn);
		Object o = ftype.newInstance();

		Iterator<String> it = fact.getFieldNames();

		while (it.hasNext()) {
			String fname = it.next();
			if (fname.equals("class"))
				continue;

			Class<?> fclass = ftype.getField(fname).getType();
			if (fclass.isAssignableFrom(String.class)) {
				ftype.set(o, fname, fact.get(fname).asText());
			} else if (fclass.isAssignableFrom(Integer.class)) {
				ftype.set(o, fname, fact.get(fname).asInt());
			} else if (fclass.isAssignableFrom(Long.class)) {
				ftype.set(o, fname, fact.get(fname).asLong());
			} else if (fclass.isAssignableFrom(Boolean.class)) {
				ftype.set(o, fname, fact.get(fname).asBoolean());
			}
		}

		return o;
	}

	public void setFactHandled(UserAction uaction) {
		FactHandle h = ksession.getFactHandle(uaction);
		ksession.retract(h);
	}

	public List<Object> getActivityRelatedFacts(Activity key) {
		return simpleListRequest(key, "Get activity related facts");
	}

	private List<Object> simpleListRequest(Object key, String qname) {
		QueryResults results = ksession.getQueryResults(qname, key);
		Iterator<QueryResultsRow> it = results.iterator();
		LinkedList<Object> ret = new LinkedList<>();
		while (it.hasNext()) {
			ret.add(it.next().get("$object"));
		}
		return ret;
	}

	public List<Object> getRequestRelatedFacts(RequestFact key) {
		List<Object> lst = simpleListRequest(key, "Get request related facts");
		// Collections.sort(lst, new Comparator<Object>() {
		// @Override
		// public int compare(Object o1, Object o2) {
		// final RequestRelatedFact r1 = (RequestRelatedFact) o1;
		// final RequestRelatedFact r2 = (RequestRelatedFact) o2;
		// return r1.get;
		// }
		// });
		return lst;
	}

	public List<Object> getRequestStatusRelatedFacts(RequestStatus key) {
		return simpleListRequest(key, "Get request status related facts");
	}
}
