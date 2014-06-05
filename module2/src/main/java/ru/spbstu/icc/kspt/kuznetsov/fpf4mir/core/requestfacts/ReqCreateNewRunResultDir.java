package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;


public class ReqCreateNewRunResultDir extends RequestFactBase implements RequestFact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8811365785142088394L;

	public ReqCreateNewRunResultDir(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqCreateNewRunResultDir(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	@Override
	public String toString() {
		return "ReqCreateNewRunResultDir []";
	}
}
