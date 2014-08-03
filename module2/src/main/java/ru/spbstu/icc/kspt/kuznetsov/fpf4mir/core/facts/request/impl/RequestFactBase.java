package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;

public class RequestFactBase implements Request, Serializable, FactWithRefId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1571771513334573701L;

	private static volatile long refIdCounter = 1;
	private long refId;
	private Activity parentActivity;
	
	public RequestFactBase() {
		this(null);
	}
	
	public RequestFactBase(Activity parentActivity) {
		this(refIdCounter++, parentActivity);
	}

	public RequestFactBase(long refId, Activity parentActivity) {
		super();
		this.refId = refId;
		this.parentActivity = parentActivity;
	}

	public Activity getParentActivity() {
		return parentActivity;
	}

	public void setParentActivity(Activity parentActivity) {
		this.parentActivity = parentActivity;
	}

	@Override
	public long getRefId() {
		return refId;
	}

	@Override
	public void setRefId(long refId) {
		this.refId = refId;
	}
	
	public RequestFactBase reset(long refId, Activity parentActivity){
		this.refId = refId;
		this.parentActivity = parentActivity;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [refId=" + refId + ", parentActivity="
				+ parentActivity + "]";
	}
	
}
