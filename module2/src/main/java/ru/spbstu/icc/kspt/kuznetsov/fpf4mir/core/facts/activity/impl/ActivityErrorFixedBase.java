package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityErrorFixed;

public class ActivityErrorFixedBase implements ActivityErrorFixed{
	private ActivityError error;

	protected ActivityErrorFixedBase(ActivityError error) {
		this.error = error;
	}
	
	public ActivityErrorFixedBase() {
	}

	public Activity getActivity() {
		return error.getActivity();
	}

	public void setActivity(Activity activity) {
		System.err.println("Mathod setActivity is not allowed for ActivityErrorFixedBase. Ignore.");
	}
	
	public ActivityError getError() {
		return error;
	}

	public void setError(ActivityError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [error=" + error + "]";
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
