package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityInProgress;

public final class GenericActivityInProgress extends ActivityStatusBase implements ActivityInProgress {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2311110161455714685L;
	
	public GenericActivityInProgress() {
		super();
	}

	public GenericActivityInProgress(Activity activity) {
		super(activity);
	}

	public GenericActivityInProgress(Activity activity, String message) {
		super(activity, message);
	}
}
