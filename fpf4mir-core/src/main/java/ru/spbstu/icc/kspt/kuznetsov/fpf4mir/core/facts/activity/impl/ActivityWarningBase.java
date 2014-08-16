package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityWarning;

public class ActivityWarningBase extends ActivityRelatedFactBase implements ActivityWarning{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8536925746869954514L;

	private String message = "<no message>";

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public ActivityWarningBase reset(Activity activity, String message){
		setActivity(activity);
		this.message = message;
		return this;
	}
}
