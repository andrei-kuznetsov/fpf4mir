package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class AddFeatureActionBase extends ActionFactBase implements AddFeatureAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -395776704050082196L;
	
	private String featureName;
	private String featureVersion;

	protected AddFeatureActionBase(Activity activity) {
		super(activity);
	}

	protected AddFeatureActionBase(Activity activity, String featureName,
			String featureVersion) {
		super(activity);
		this.featureName = featureName;
		this.featureVersion = featureVersion;
	}

	protected AddFeatureActionBase(Activity activity, String featureName) {
		this(activity, featureName, null);
	}
	
	public String getFeatureName() {
		return featureName;
	}

	public void setFeatureName(String featureName) {
		this.featureName = featureName;
	}

	public String getFeatureVersion() {
		return featureVersion;
	}

	public void setFeatureVersion(String featureVersion) {
		this.featureVersion = featureVersion;
	}

}
