package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class GenericUserActionStatus extends UserActionStatusBase implements UserActionStatus{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3766550387899717904L;

	public GenericUserActionStatus() {
		super();
	}

	public GenericUserActionStatus(Activity activity) {
		super(activity);
	}

}
