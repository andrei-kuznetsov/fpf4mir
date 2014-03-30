package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class ActivityErrorFixed {
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
