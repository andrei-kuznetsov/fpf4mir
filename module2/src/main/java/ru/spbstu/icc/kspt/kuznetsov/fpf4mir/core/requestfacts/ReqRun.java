package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ReqNewActivityBase;

public class ReqRun extends ReqNewActivityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6323213569847757409L;

	public ReqRun() {
		super();
	}

	public ReqRun(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqRun(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}
	
}
