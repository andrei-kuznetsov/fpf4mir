package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResultFailed;

public final class GenericActivityResultFailed extends ActivityResultBase implements ActivityResultFailed{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4705094944153211780L;

	public GenericActivityResultFailed() {
		super();
	}

	public GenericActivityResultFailed(Activity activity, String message) {
		super(activity, message);
	}

	public GenericActivityResultFailed(Activity activity) {
		super(activity);
	}

	
}
