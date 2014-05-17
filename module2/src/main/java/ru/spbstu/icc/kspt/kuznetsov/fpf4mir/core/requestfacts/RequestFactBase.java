package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class RequestFactBase implements RequestFact {
	private long refId;
	private Activity parentActivity;

	public RequestFactBase(long refId, Activity parentActivity) {
		super();
		this.refId = refId;
		this.parentActivity = parentActivity;
	}

	public RequestFactBase(Activity parentActivity) {
		this(0, parentActivity);
	}

	public Activity getParentActivity() {
		return parentActivity;
	}

	public void setParentActivity(Activity parentActivity) {
		this.parentActivity = parentActivity;
	}

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}
}
