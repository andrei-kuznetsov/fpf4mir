package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class GenericFeatureInUse extends ActivityRelatedFactBase implements FeatureInUse {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2608604537057852938L;
	
	private Feature feature;

	public GenericFeatureInUse(Activity activity, Feature feature) {
		super(activity);
		this.feature = feature;
	}

	public GenericFeatureInUse() {

	}
	
	public Feature getFeature() {
		return feature;
	}

	public void setFeature(Feature feature) {
		this.feature = feature;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [feature=" + feature + "]";
	}
	
	
}
