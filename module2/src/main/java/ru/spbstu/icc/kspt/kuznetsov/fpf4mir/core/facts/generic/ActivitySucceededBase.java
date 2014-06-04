package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceeded;

public class ActivitySucceededBase extends ActivityStatusBase implements ActivitySucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5636510703249830354L;

	public ActivitySucceededBase() {
		super();
	}

	public ActivitySucceededBase(Activity activity) {
		super(activity);
	}

}
