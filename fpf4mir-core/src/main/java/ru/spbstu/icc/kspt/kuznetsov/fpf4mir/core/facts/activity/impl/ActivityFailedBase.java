package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityFailed;

public class ActivityFailedBase extends ActivityStatusBase implements ActivityFailed{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287526973266183983L;
	
	
	public ActivityFailedBase() {
		super();
	}

	public ActivityFailedBase(Activity activity, String message) {
		super(activity, message);
	}

	public ActivityFailedBase(Activity activity) {
		super(activity);
	}

}
