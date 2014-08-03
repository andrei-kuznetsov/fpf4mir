package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;

public class RequestFactBase extends ActivityRelatedFactBase implements Request, Serializable, FactWithRefId {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1571771513334573701L;

	private static volatile long refIdCounter = 1;
	private long refId;
	
	public RequestFactBase() {
		this(null);
	}
	
	public RequestFactBase(Activity parentActivity) {
		this(refIdCounter++, parentActivity);
	}

	public RequestFactBase(long refId, Activity parentActivity) {
		super(parentActivity);
		this.refId = refId;
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
		super.reset(parentActivity);
		this.refId = refId;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [refId=" + refId + ", parentActivity="
				+ getActivity() + "]";
	}
	
}
