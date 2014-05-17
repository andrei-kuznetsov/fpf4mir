package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class GenericReqNewActivity implements ReqNewActivity{
	private String activityName;
	private long refId;
	private Activity parentActivity;

	public GenericReqNewActivity(String activityName, long refId, Activity parentActivity) {
		super();
		this.activityName = activityName;
		this.refId = refId;
		this.parentActivity = parentActivity;
	}

	public GenericReqNewActivity(String activityName, Activity parentActivity) {
		this(activityName, 0, parentActivity);
	}

	public GenericReqNewActivity(String activityName) {
		this(activityName, 0, null);
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
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new GenericActivity(activityName, (int)date.getTime(), date, this);
	}
}
