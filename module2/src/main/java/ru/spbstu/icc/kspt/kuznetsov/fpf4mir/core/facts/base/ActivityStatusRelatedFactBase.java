package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityStatusRelatedFact;

public class ActivityStatusRelatedFactBase implements ActivityStatusRelatedFact, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7009909694923412940L;
	
	private ActivityStatus astatus;

	public ActivityStatusRelatedFactBase() {
		super();
	}
	
	public ActivityStatusRelatedFactBase(ActivityStatus astatus) {
		super();
		this.astatus = astatus;
	}

	public ActivityStatus getAstatus() {
		return astatus;
	}

	public void setAstatus(ActivityStatus astatus) {
		this.astatus = astatus;
	}
	
}
