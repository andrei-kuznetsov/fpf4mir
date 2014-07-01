package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatus;

public class ActivityStatusBase extends ActivityRelatedFactBase implements ActivityStatus{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8613785108974188496L;

	private String message;
	
	public ActivityStatusBase() {
		super();
	}

	public ActivityStatusBase(Activity activity) {
		super(activity);
	}

	public ActivityStatusBase(Activity activity, String message) {
		super(activity);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ActivityStatusBase reset(Activity activity, String message){
		super.reset(activity);
		this.message = message;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [message=" + message + "]";
	}
}
