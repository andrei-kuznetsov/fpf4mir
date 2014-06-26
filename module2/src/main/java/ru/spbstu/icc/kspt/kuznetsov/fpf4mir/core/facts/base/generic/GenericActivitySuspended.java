package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySuspended;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityStatusBase;

public class GenericActivitySuspended extends ActivityStatusBase implements ActivitySuspended {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2311110161455714685L;
	
	public GenericActivitySuspended() {
		super();
	}

	public GenericActivitySuspended(Activity activity) {
		super(activity);
	}

	public GenericActivitySuspended(Activity activity, String message) {
		super(activity, message);
	}
}
