package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class GenericReqNewActivity implements ReqNewActivity{
	private String activityName;
	private long refId;
	private Activity parentActivity;

	public GenericReqNewActivity reset(String activityName, long refId, Activity parentActivity) {
		this.activityName = activityName;
		this.refId = refId;
		this.parentActivity = parentActivity;
		return this;
	}

	public GenericReqNewActivity reset(String activityName, Activity parentActivity) {
		return this.reset(activityName, 0, parentActivity);
	}

	public GenericReqNewActivity reset(String activityName) {
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
}
