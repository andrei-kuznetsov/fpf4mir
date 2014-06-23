package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySuspended;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class GenericActivitySuspended extends ActivityStatusBase implements ActivitySuspended {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2311110161455714685L;
	private String message;
	
	public GenericActivitySuspended() {
		super();
	}

	public GenericActivitySuspended(Activity activity) {
		super(activity);
	}

	public GenericActivitySuspended(Activity activity, String message) {
		super(activity);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public GenericActivitySuspended reset(Activity activity, String message){
		super.reset(activity);
		this.message = message;
		return this;
	}
}
