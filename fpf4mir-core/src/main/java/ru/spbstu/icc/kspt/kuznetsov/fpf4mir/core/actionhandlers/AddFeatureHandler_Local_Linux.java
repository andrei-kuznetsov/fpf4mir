package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.definition.type.FactType;
import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features.Feature;

public class AddFeatureHandler_Local_Linux implements ActionHandler {

	@Override
	public void process(Action action, StatefulKnowledgeSession ksession)
			throws Exception {
		if (action instanceof AddFeatureAction){
			AddFeatureAction a = (AddFeatureAction) action;
			Feature feature = installFeature(a.getFeatureName(), a.getFeatureVersion(), ksession);
			ksession.retract(ksession.getFactHandle(action));
			ksession.insert(feature);
		} else {
			throw new IllegalStateException("Action type '" + action.getClass().getSimpleName() + "' is not supported");
		}
	}

	private Feature installFeature(String featureName, String featureVersion, StatefulKnowledgeSession ks) throws InstantiationException, IllegalAccessException {
		if (featureName == null){
			throw new IllegalStateException("Feature name can't be null");
		}

		switch (featureName){
		case "maven":
			return installMaven(featureVersion, ks);
		default:
			throw new IllegalStateException("Feature '" + featureName + "' is not supported");
		}
	}

	private Feature installMaven(String featureVersion, StatefulKnowledgeSession ks) throws InstantiationException, IllegalAccessException {
		if ("3".equals(featureVersion) || "3.1".equals(featureVersion) || "3.1.1".equals(featureVersion)){
			return createMavenFeature("3.1.1", "/home/andrei2/OpenShift/apache-maven-3.1.1/bin/mvn", ks);
		} else if ("3.0".equals(featureVersion) || "3.0.5".equals(featureVersion)){
			return createMavenFeature("3.0.5", "/home/andrei2/OpenShift/apache-maven-3.0.5/bin/mvn", ks);
		} else if (featureVersion == null){
			return createMavenFeature("default", "mvn", ks);
		} else {
			throw new IllegalStateException("Maven feature version '" + featureVersion + "' is not supported");
		}
	}
	
	static final Feature createMavenFeature(String version, String cmdName, StatefulKnowledgeSession ks) throws InstantiationException, IllegalAccessException{
		FactType ftype = DeploymentSession.factTypeForClassName("defaultpkg.MavenFeature", ks);
		Object f = ftype.newInstance();
		ftype.set(f, "name", "maven");
		ftype.set(f, "cmdName", cmdName);
		ftype.set(f, "version", version);
		return (Feature)f;
	}

}
