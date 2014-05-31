package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySuspended;

public class GenericActivitySuspended extends ActivityStatusBase implements ActivitySuspended {
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


}
