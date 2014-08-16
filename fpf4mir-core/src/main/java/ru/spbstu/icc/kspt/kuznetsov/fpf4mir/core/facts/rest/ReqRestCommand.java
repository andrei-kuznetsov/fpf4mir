package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.RequestBase;

public class ReqRestCommand extends RequestBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3132391379785967012L;

	public ReqRestCommand() {
		super();
	}

	public ReqRestCommand(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqRestCommand(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

}
