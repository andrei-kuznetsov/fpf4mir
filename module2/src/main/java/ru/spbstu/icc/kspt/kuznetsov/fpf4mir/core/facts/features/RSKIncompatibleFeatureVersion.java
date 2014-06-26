package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.RequestScopedKnowledgeBase;

public class RSKIncompatibleFeatureVersion extends RequestScopedKnowledgeBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3191745902327818957L;

	private Feature feature;

	public RSKIncompatibleFeatureVersion(Feature feature) {
		super();
		this.feature = feature;
	}

	public RSKIncompatibleFeatureVersion() {
	}

	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}
	
	public String getFeatureVersion(){
		return feature.getVersion();
	}
	
	public String getFeatureName(){
		return feature.getName();
	}
	
	public RSKIncompatibleFeatureVersion reset(Activity activity, Feature feature){
		super.reset(activity);
		this.feature = feature;
		return this;
	}
}
