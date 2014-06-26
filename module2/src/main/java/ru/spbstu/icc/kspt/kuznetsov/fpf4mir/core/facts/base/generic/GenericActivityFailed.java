package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityFailedBase;

public class GenericActivityFailed extends ActivityFailedBase {

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

	public GenericActivityFailed(Activity activity, String message, String type) {
		super(activity, message, type);
	}

}
