package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public abstract class ActionStatusBase implements ActionStatus, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3231409981740220661L;
	private Activity activity;
	
	public ActionStatusBase(Activity activity) {
		super();
		this.activity = activity;
	}

	@Override
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
