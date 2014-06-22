package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.AddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features.Feature;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features.MavenFeature;

public class AddFeatureHandler_Local implements ActionHandler {

	@Override
	public void process(ActionFact action, StatefulKnowledgeSession ksession)
			throws Exception {
		if (action instanceof AddFeatureAction){
			AddFeatureAction a = (AddFeatureAction) action;
			Feature feature = installFeature(a.getFeatureName(), a.getFeatureVersion());
			ksession.retract(ksession.getFactHandle(action));
			ksession.insert(feature);
		} else {
			throw new IllegalStateException("Action type '" + action.getClass().getSimpleName() + "' is not supported");
		}
	}

	private Feature installFeature(String featureName, String featureVersion) {
		if (featureName == null){
			throw new IllegalStateException("Feature name can't be null");
		}

		switch (featureName){
		case "maven":
			return installMaven(featureVersion);
		default:
			throw new IllegalStateException("Feature '" + featureName + "' is not supported");
		}
	}

	private MavenFeature installMaven(String featureVersion) {
		if ("3".equals(featureVersion) || "3.1".equals(featureVersion) || "3.1.1".equals(featureVersion)){
			MavenFeature mvn = new MavenFeature();
			mvn.setCmdName("D:\\Program_Files\\apache-maven-3.1.1\\bin\\mvn.bat");
			mvn.setVersion("3.1.1");
			return mvn;
		} else if (featureVersion == null || "3.0".equals(featureVersion) || "3.0.4".equals(featureVersion)){
			MavenFeature mvn = new MavenFeature();
			mvn.setCmdName("D:\\Program_Files\\apache-maven-3.0.4\\bin\\mvn.bat");
			mvn.setVersion("3.0.4");
			return mvn;
		} else {
			throw new IllegalStateException("Maven feature version '" + featureVersion + "' is not supported");
		}
	}

}
