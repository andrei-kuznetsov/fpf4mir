package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;

public class ActionFactBase<U extends ActivityRelatedFact> extends ActivityRelatedFactBase implements Action, FactWithRefId{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2616511145672466780L;

	private static volatile long refIdCounter = 0; 
	
	private long refId = refIdCounter++;

	protected U parameter;
	
	public ActionFactBase() {
		super();
	}

	public ActionFactBase(Activity activity) {
		super(activity);
	}

	@Override
	public long getRefId() {
		return refId;
	}

	@Override
	public void setRefId(long refId) {
		this.refId = refId;
	}

	@Override
	public void setParameter(ActivityRelatedFact param) {
		parameter = (U)param;
	}

	@Override
	public U getParameter() {
		return parameter;
	}
}
