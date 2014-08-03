package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
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
import org.drools.definition.type.FactField;
import org.drools.definition.type.FactType;
import org.drools.io.ResourceFactory;
import org.drools.logger.KnowledgeRuntimeLogger;
import org.drools.logger.KnowledgeRuntimeLoggerFactory;
import org.drools.marshalling.Marshaller;
import org.drools.marshalling.MarshallerFactory;
import org.drools.runtime.ObjectFilter;
import org.drools.runtime.StatefulKnowledgeSession;
import org.drools.runtime.rule.FactHandle;
import org.drools.runtime.rule.QueryResults;
import org.drools.runtime.rule.QueryResultsRow;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.AddFeatureHandler_Local_Linux;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.AddFeatureHandler_Local_Windows;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ExecActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericAddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatusRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.userinfo.UserInfo;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.OS;

public class DeploymentSession {
	private static final String QKEY_ACTIVITY_OBJECT = "$object";

	private static DeploymentSession dsession = null;
	
	public static enum EXECUTION_STATE {
		RUNNING, DONE, WAITING_FOR_USER
	};

	private static final String QKEY_STATUS = "$rstatus";
	private static final String QKEY_ACTIVITY = "activities";
	private static final String QKEY_EXTRAS = "extras";

	private KnowledgeBase kbase = null;
	private StatefulKnowledgeSession ksession = null;
	private KnowledgeRuntimeLogger logger = null;
	private Marshaller marshaller;
	private static final Logger log = Logger.getLogger(DeploymentSession.class);
	private static final Map<Class<? extends Action>, ActionHandler> actionsMap = new HashMap<Class<? extends Action>, ActionHandler>();

	private EXECUTION_STATE state = EXECUTION_STATE.DONE;

	public void init() throws Exception {
		init(null);
	}
	
	public void init(InputStream is) throws Exception {

		log.setLevel(Level.ALL);

		initActions();

		initKBase();
		
		if (is == null){
			initStatefulSession();
		} else {
			unmarshallKSession(is);
		}

		// now insert environment facts
		initExecEnvironment();

		log.info("Execution completed!");
	}

	public void storeKSession(OutputStream os) throws IOException{
		marshaller.marshall(os, ksession);
	}
	
	private void unmarshallKSession(InputStream is) throws ClassNotFoundException, IOException {
		ksession = marshaller.unmarshall(is);
		ksession.addEventListener(new AgendaDebugListener());
		logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
	}

	private void initExecEnvironment() {
		String dataDir = System.getenv().get("OPENSHIFT_DATA_DIR");
		if (dataDir == null) {
			dataDir = "OpenShift\\datadir";
		}
		File f = new File(dataDir);
		f.mkdirs();
		log.info("Data dir: " + f.getAbsolutePath());
		ksession.insert(new DataDirRoot(ActivityBase.USER, f.getAbsolutePath(), ""));
	}

	private static void initActions() {
		actionsMap.put(GenericExecAction.class, new ExecActionHandler());
		
		if (OS.isWindows()){
			actionsMap.put(GenericAddFeatureAction.class, new AddFeatureHandler_Local_Windows());
		} else {
			actionsMap.put(GenericAddFeatureAction.class, new AddFeatureHandler_Local_Linux());
		}

	}

	public void run() throws Exception {
		boolean doContinue = false;
		do {
			try {
				ksession.fireAllRules();
				Collection actions = ksession.getObjects(new ObjectFilter() {
					@Override
					public boolean accept(Object object) {
						return (object instanceof Action);
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
			Collection<? extends Action> actions) throws Exception {

		final EXECUTION_STATE ret;

		boolean hasUserAction = false;
		boolean hasNonUserAction = false;

		for (Action i : actions) {
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
		ksession = kbase.newStatefulKnowledgeSession();

		// ksession.addEventListener(new DebugAgendaEventListener());
		// ksession.addEventListener(new DebugWorkingMemoryEventListener());
		ksession.addEventListener(new AgendaDebugListener());
		logger = KnowledgeRuntimeLoggerFactory.newFileLogger(ksession, "test");
//		logger = KnowledgeRuntimeLoggerFactory.newConsoleLogger(ksession);
		initGlobals(kbase, ksession);
	}

	private void initKBase() throws ZipException, IOException {
		KnowledgeBuilder kbuilder = KnowledgeBuilderFactory
				.newKnowledgeBuilder();

		addKBEntries(kbuilder);

		kbase = kbuilder.newKnowledgeBase();
		marshaller = MarshallerFactory.newMarshaller(kbase);
	}

	protected void addKBEntries(KnowledgeBuilder kbuilder) throws ZipException,
			IOException {
		URL t = DeploymentSession.class.getClassLoader().getResource(
				"basic_actions.dslr");
		System.out.println("DRL is:" + t);

		if (t == null)
			throw new RuntimeException();

		log.debug("Looking for *.drl files");


		addAllClassPathResources(kbuilder, "definitions.drl", ResourceType.DRL);
		addAllClassPathResources(kbuilder, "functions.drl", ResourceType.DRL);
		addAllClassPathResources(kbuilder, "queries.drl", ResourceType.DRL);
		
		addClassPathEntry(kbuilder, "preprocess.drl", ResourceType.DRL);

//		kbase = kbuilder.newKnowledgeBase();
//		debugTactType(kbase, "defaultpkg", "DeployFolder");
//		debugTactType(kbase, "defaultpkg", "ReqDownloadHttp");

		String[] dslFiles = Classpath
				.getClasspathFileNamesWithExtension(".dsl");
		for (String resFileName : dslFiles)
			addClassPathEntry(kbuilder, resFileName, ResourceType.DSL);

		String[] dslrFiles = Classpath
				.getClasspathFileNamesWithExtension(".dslr");
		for (String resFileName : dslrFiles)
			addClassPathEntry(kbuilder, resFileName, ResourceType.DSLR);
	}

	protected void addAllClassPathResources(KnowledgeBuilder kbuilder, String fname, ResourceType rtype)
			throws ZipException, IOException {
		String[] defFiles = Classpath
				.getClasspathFileNamesWithExtension(fname);
		Arrays.sort(defFiles);
		for (String resFileName : defFiles)
			addClassPathEntry(kbuilder, resFileName, rtype);
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

	public static void addClassPathEntry(KnowledgeBuilder kbuilder,
			String resFileName, ResourceType type) {
		if (resFileName.indexOf('/') == -1 || resFileName.startsWith("rules/")) {
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

		if (logger != null){
			logger.close();
			logger = null;
		}
	}


	public void reset(FileInputStream fis) throws Exception {
		this.dispose();
		this.init(fis);
	}
	
	public void reset() throws Exception {
		reset(null);
	}

	public void assertFactAndRun(Object... f) throws Exception {
		assertFact(f);
		this.run();
	}

	public void assertFact(Object... f) {
		for (Object i : f) {
			ksession.insert(i);
		}
	}

	public static class QResult {
		public RequestStatus mainStatus;
		public List<Activity> activities;
		public List<RequestStatusRelatedFact> extras;

		public QResult(RequestStatus mainStatus, List<Activity> activities,
				List<RequestStatusRelatedFact> extras) {
			super();
			this.mainStatus = mainStatus;
			this.activities = activities;
			this.extras = extras;
		}

		public RequestStatus getMainStatus() {
			return mainStatus;
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
				List<Activity> activities = (List<Activity>) row
						.get(QKEY_ACTIVITY);

				List<RequestStatusRelatedFact> extras = (List<RequestStatusRelatedFact>) row
						.get(QKEY_EXTRAS);

				QResult r = new QResult(status, activities, extras);
				parsedResults.add(r);
			}

		} else {
			log.warn("No results found for request.");
		}

		return parsedResults;
	}

	public List<QResult> getRequestStatus(Request req) {
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
			IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		final String className = fact.get("class").asText();

		final String pkg = className.substring(0, className.lastIndexOf('.'));
		final String cn = className.substring(className.lastIndexOf('.') + 1);
		FactType ftype = ksession.getKnowledgeBase().getFactType(pkg, cn);
		
		if (ftype == null){
			log.error("Can't find class definition for " + className);
			throw new IllegalStateException("Can't find class definition for " + className);
		}
		
		Object o = ftype.newInstance();

		Iterator<String> it = fact.getFieldNames();

		while (it.hasNext()) {
			String fname = it.next();
			if (fname.equals("class"))
				continue;

			FactField field = ftype.getField(fname);
			final Class<?> fclass;
			if (field == null){
				PropertyDescriptor propertyDescriptor;
				try {
					propertyDescriptor = new PropertyDescriptor(fname, ftype.getFactClass());
				} catch (IntrospectionException e) {
					final String msg = "Can't find field '" + fname + "' in class " + className;
					log.error(msg);
					throw new IllegalStateException(msg, e);
				}

				fclass = propertyDescriptor.getPropertyType();
				propertyDescriptor.getWriteMethod().invoke(o, typedJsonObject(fact.get(fname), fclass));
			} else {
				fclass = field.getType();
				ftype.set(o, fname, typedJsonObject(fact.get(fname), fclass));
			}
		}

		return o;
	}
	
	private Object typedJsonObject(JsonNode node, Class<?> fclass){
		if (fclass.isAssignableFrom(String.class)) {
			return node.asText();
		} else if (fclass.isAssignableFrom(Integer.class)) {
			return node.asInt();
		} else if (fclass.isAssignableFrom(Long.class)) {
			return node.asLong();
		} else if (fclass.isAssignableFrom(Boolean.class)) {
			return node.asBoolean();
		} else {
			throw new IllegalStateException("Don't know how to parse type " + fclass);
		}
	}

	public void setFactHandled(UserAction uaction) {
		FactHandle h = ksession.getFactHandle(uaction);
		ksession.retract(h);
	}

	public List<Object> getActivityRelatedFacts(Activity key) {
		return simpleListRequest(key, "Get activity related facts");
	}

	private <U> List<U> simpleListRequest(Object key, String qname) {
		QueryResults results = ksession.getQueryResults(qname, key);
		Iterator<QueryResultsRow> it = results.iterator();
		LinkedList<U> ret = new LinkedList<>();
		while (it.hasNext()) {
			ret.add((U)it.next().get("$object"));
		}
		return ret;
	}

	public List<Object> getRequestRelatedFacts(Request key) {
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

	public List<Object> getActivityStatusRelatedFacts(ActivityStatus key) {
		return simpleListRequest(key, "Get activity status related facts");
	}
	
	public List<UserInfo> getUserInfoFacts(ActivityStatus key) {
		return simpleListRequest(key, "Get userInfo facts for request");
	}

	public static DeploymentSession getInstance() {
		if (dsession == null){
			dsession = new DeploymentSession();
		}
		return dsession;
	}
	
	protected DeploymentSession(){
	}

	public List<Activity> getRoots() {
		return simpleListRequest(null, "Get root activities");
	}
}
