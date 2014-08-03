package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.ReqNewActivity;

public class ReqNewActivityBase extends RequestFactBase implements ReqNewActivity{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3018605309657222587L;

	public ReqNewActivityBase() {
		super();
	}

	public ReqNewActivityBase(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqNewActivityBase(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}
}
