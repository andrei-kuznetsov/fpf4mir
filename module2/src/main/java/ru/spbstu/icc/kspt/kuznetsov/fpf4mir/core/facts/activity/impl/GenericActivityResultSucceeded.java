package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResultSucceeded;

public final class GenericActivityResultSucceeded extends ActivityResultBase implements ActivityResultSucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3818192422117613656L;

	public GenericActivityResultSucceeded() {
		super();
	}

	public GenericActivityResultSucceeded(Activity activity, String message) {
		super(activity, message);
	}

	public GenericActivityResultSucceeded(Activity activity) {
		super(activity);
	}


}
