package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class ActivityRelatedFactBase implements ActivityRelatedFact,
		FPFCloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1882723079566142858L;

	private Activity activity;

	protected ActivityRelatedFactBase(Activity activity) {
		super();
		this.activity = activity;
	}

	protected ActivityRelatedFactBase() {

	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [activity=" + activity + "]";
	}

	public ActivityRelatedFactBase reset(Activity activity) {
		this.activity = activity;
		return this;
	}
}
