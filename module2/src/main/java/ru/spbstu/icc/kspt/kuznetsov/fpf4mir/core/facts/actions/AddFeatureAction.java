package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;


public interface AddFeatureAction extends Action{
	
	public String getFeatureName();
	public void setFeatureName(String featureName);

	public String getFeatureVersion();
	public void setFeatureVersion(String featureVersion);

}
