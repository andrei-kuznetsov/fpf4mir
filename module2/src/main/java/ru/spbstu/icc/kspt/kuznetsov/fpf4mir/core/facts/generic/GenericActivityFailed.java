package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityFailed;

public class GenericActivityFailed extends ActivityStatusBase implements ActivityFailed{
	private String message = "no message";
	
	public GenericActivityFailed() {
		super();
	}

	public GenericActivityFailed(Activity activity) {
		super(activity);
	}

	public GenericActivityFailed(Activity activity, String message) {
		super(activity);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "GenericActivityFailed [message=" + message + ", getActivity()="
				+ getActivity() + "]";
	}

}
