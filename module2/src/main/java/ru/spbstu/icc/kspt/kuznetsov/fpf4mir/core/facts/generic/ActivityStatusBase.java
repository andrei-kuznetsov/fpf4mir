package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;

public class ActivityStatusBase extends ActivityRelatedFactBase implements ActivityStatus{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613785108974188496L;

	public ActivityStatusBase() {
		super();
	}

	public ActivityStatusBase(Activity activity) {
		super(activity);
	}
}
