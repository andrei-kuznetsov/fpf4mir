package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class ActivityRelatedFactBase implements ActivityRelatedFact,
		FPFCloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1882723079566142858L;

	private Activity activity;

	public ActivityRelatedFactBase(Activity activity) {
		super();
		this.activity = activity;
	}

	public ActivityRelatedFactBase() {

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
