package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class ActivityRelatedFactBase implements ActivityRelatedFact, FPFCloneable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1882723079566142858L;
	
	private Activity activity;

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
}
