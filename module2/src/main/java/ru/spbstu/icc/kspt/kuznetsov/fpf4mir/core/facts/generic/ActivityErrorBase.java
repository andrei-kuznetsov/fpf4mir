package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityError;

public class ActivityErrorBase extends ActivityRelatedFactBase implements ActivityError{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8836066602385597753L;
	
	private String message;

	public ActivityErrorBase() {
	}
	
	public ActivityErrorBase(Activity activity, String message) {
		super(activity);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ActivityErrorBase reset(Activity activity, String message){
		super.reset(activity);
		this.message = message;
		return this;
	}
}
