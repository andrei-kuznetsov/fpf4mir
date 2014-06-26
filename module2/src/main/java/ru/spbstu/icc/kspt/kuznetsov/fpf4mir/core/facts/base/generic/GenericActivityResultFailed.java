package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityResultFailed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;

public class GenericActivityResultFailed extends ActivityRelatedFactBase implements ActivityResultFailed{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4705094944153211780L;

	private String message;
	
	public GenericActivityResultFailed() {
		super();
	}

	public GenericActivityResultFailed(Activity activity) {
		super(activity);
	}

	public GenericActivityResultFailed(Activity activity, String message) {
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
		return "GenericActivityResultFailed [message=" + message + "]";
	}

}
