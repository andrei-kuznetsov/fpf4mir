package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public abstract class ActionStatusBase implements ActionStatus {
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
