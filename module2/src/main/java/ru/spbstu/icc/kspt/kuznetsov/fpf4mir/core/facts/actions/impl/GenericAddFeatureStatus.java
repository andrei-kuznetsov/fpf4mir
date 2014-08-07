package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public final class GenericAddFeatureStatus extends AddFeatureStatusBase implements AddFeatureStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5230603779660550329L;

	public GenericAddFeatureStatus() {
		super();
	}

	public GenericAddFeatureStatus(Activity activity) {
		super(activity);
	}

}
