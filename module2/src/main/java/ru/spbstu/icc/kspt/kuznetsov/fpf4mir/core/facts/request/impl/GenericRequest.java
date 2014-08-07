package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;

public class GenericRequest extends RequestBase implements Request{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6079858048497373242L;

	public GenericRequest() {
		super();
	}

	public GenericRequest(Activity parentActivity) {
		super(parentActivity);
	}

	public GenericRequest(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

}
