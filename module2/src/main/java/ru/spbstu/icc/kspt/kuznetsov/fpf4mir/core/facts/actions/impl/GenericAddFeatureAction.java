package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class GenericAddFeatureAction extends AddFeatureActionBase implements AddFeatureAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4089484308177423140L;

	public GenericAddFeatureAction(Activity activity, String featureName,
			String featureVersion) {
		super(activity, featureName, featureVersion);
	}

	public GenericAddFeatureAction(Activity activity, String featureName) {
		super(activity, featureName);
	}

	public GenericAddFeatureAction(Activity activity) {
		super(activity);
	}

}
