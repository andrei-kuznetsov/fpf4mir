package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResult;

public class ActivityResultBase extends ActivityRelatedFactBase implements ActivityResult{
	
	private String message;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4999979863862789885L;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	protected ActivityResultBase() {
		super();
	}

	protected ActivityResultBase(Activity activity) {
		super(activity);
	}

	public ActivityResultBase(Activity activity, String message) {
		super(activity);
		this.message = message;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [message=" + message + "]";
	}

}
