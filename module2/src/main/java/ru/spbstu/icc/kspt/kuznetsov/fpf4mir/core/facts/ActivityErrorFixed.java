package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class ActivityErrorFixed implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5599505171674685786L;
	
	private ActivityError error;

	public ActivityErrorFixed(ActivityError error) {
		this.error = error;
	}

	public Activity getActivity() {
		return error.getActivity();
	}

	public ActivityError getError() {
		return error;
	}

	public void setError(ActivityError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ActivityErrorFixed [error=" + error + "]";
	}

}
