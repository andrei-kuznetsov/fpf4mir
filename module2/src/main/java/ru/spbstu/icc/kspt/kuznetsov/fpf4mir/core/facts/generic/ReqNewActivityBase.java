package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class ReqNewActivityBase implements ReqNewActivity{
	private String activityName;
	private long refId;
	private Activity parentActivity;

	public ReqNewActivityBase reset(String activityName, long refId, Activity parentActivity) {
		this.activityName = activityName;
		this.refId = refId;
		this.parentActivity = parentActivity;
		return this;
	}

	public ReqNewActivityBase reset(String activityName, Activity parentActivity) {
		return this.reset(activityName, 0, parentActivity);
	}

	public ReqNewActivityBase reset(String activityName) {
		return this.reset(activityName, 0, null);
	}

	public long getRefId() {
		return refId;
	}


	public void setRefId(long refId) {
		this.refId = refId;
	}


	public Activity getParentActivity() {
		return parentActivity;
	}

	public void setParentActivity(Activity parentActivity) {
		this.parentActivity = parentActivity;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [activityName=" + activityName + ", refId="
				+ refId + "]";
	}
	
}
