package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public final class GenericActivityFailed extends ActivityFailedBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1937028327487900101L;

	public GenericActivityFailed() {
		super();
	}

	public GenericActivityFailed(Activity activity, String message) {
		super(activity, message);
	}

	public GenericActivityFailed(Activity activity) {
		super(activity);
	}

}
