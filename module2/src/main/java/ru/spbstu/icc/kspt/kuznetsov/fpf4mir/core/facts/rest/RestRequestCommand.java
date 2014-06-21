package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class RestRequestCommand extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3132391379785967012L;
	private static volatile long refIdCounter = 1;
	private long refId = refIdCounter++;
	
	public RestRequestCommand() {
		super();
	}

	public RestRequestCommand(Activity activity) {
		super(activity);
	}

	public long getRefId() {
		return refId;
	}

	public void setRefId(long refId) {
		this.refId = refId;
	}

	@Override
	public String toString() {
		return  getClass().getSimpleName() + " [refId=" + refId + ", getActivity()="
				+ getActivity() + "]";
	}
}
