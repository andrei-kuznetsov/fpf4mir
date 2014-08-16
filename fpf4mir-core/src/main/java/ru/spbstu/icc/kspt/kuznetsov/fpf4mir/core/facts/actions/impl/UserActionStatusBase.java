package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class UserActionStatusBase extends ActionStatusBase implements UserActionStatus{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3470431558274177045L;
	private boolean succeeded;
	
	public UserActionStatusBase() {
		super();
	}

	public UserActionStatusBase(Activity activity) {
		super(activity);
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

}
