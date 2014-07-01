package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ReqNewActivityBase;

public final class GenericReqNewActivity extends ReqNewActivityBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3675042902246719963L;

	public GenericReqNewActivity() {
		super();
	}

	public GenericReqNewActivity(Activity parentActivity) {
		super(parentActivity);
	}

	public GenericReqNewActivity(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

}
