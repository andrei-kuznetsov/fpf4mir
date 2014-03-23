package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class ActivityErrorFixed {
	private Activity activity;
	private ActivityError error;

	public ActivityErrorFixed(Activity activity, ActivityError error) {
		this.activity = activity;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public ActivityError getError() {
		return error;
	}

	public void setError(ActivityError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ActivityErrorFixed [activity=" + activity + ", error=" + error
				+ "]";
	}

}
