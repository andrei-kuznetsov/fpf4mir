package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class RequestFactBase implements RequestFact {
	private long refId;
	private Activity parentActivity;

	public RequestFactBase() {
		this(0);
	}
	
	public RequestFactBase(long refId) {
		this(refId, null);
	}

	public RequestFactBase(long refId, Activity parentActivity) {
		super();
		this.refId = refId;
		this.parentActivity = parentActivity;
	}

	public RequestFactBase(Activity parentActivity) {
		this(0, parentActivity);
		if (parentActivity.getRequest() != null){
			this.refId = parentActivity.getRequest().getRefId();
		}
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
