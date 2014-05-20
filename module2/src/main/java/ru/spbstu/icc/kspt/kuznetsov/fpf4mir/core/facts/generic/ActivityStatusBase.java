package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;

public class ActivityStatusBase implements ActivityStatus{
	private Activity activity;

	protected ActivityStatusBase() {
		
	}
	
	protected ActivityStatusBase(Activity activity) {
		super();
		this.activity = activity;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
}
