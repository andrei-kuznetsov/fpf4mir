package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityFailed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class ActivityFailedBase extends ActivityStatusBase implements ActivityFailed{
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287526973266183983L;
	private String message = "no message";
	private String type = "";
	
	public ActivityFailedBase() {
		super();
	}

	public ActivityFailedBase(Activity activity) {
		this(activity, null, null);
	}

	public ActivityFailedBase(Activity activity, String message) {
		this(activity, null, message);
	}

	public ActivityFailedBase(Activity activity, String type, String message) {
		super(activity);
		this.message = message;
		this.type = type;
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [message=" + message + ", type=" + type
				+ "]";
	}

}
