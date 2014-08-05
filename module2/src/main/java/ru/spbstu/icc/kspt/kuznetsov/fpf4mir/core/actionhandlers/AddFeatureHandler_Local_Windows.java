package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features.Feature;

public class AddFeatureHandler_Local_Windows implements ActionHandler {

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
		if (featureVersion == null || "3".equals(featureVersion) || "3.1".equals(featureVersion) || "3.1.1".equals(featureVersion)){
			return AddFeatureHandler_Local_Linux. createMavenFeature("3.1.1", "D:\\Program_Files\\apache-maven-3.1.1\\bin\\mvn.bat", ks);
		} else if ("3.0".equals(featureVersion) || "3.0.4".equals(featureVersion)){
			return AddFeatureHandler_Local_Linux. createMavenFeature("3.0.4", "D:\\Program_Files\\apache-maven-3.0.4\\bin\\mvn.bat", ks);
		} else {
			throw new IllegalStateException("Maven feature version '" + featureVersion + "' is not supported");
		}
	}

}
