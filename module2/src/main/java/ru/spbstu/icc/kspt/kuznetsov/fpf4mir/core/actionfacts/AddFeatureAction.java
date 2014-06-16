package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class AddFeatureAction extends ActionFactBase implements ActionFact{
	private String featureName;
	private String featureVersion;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -395776704050082196L;

	public AddFeatureAction(Activity activity) {
		super(activity);
	}

	public AddFeatureAction(Activity activity, String featureName,
			String featureVersion) {
		super(activity);
		this.featureName = featureName;
		this.featureVersion = featureVersion;
	}

	public AddFeatureAction(Activity activity, String featureName) {
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
