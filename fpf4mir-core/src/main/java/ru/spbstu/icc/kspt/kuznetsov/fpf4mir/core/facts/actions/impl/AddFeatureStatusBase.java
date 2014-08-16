package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.AddFeatureStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class AddFeatureStatusBase extends ActionStatusBase implements AddFeatureStatus{
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272137522429973726L;
	private boolean succeeded;
	
	protected AddFeatureStatusBase() {
		super();
	}

	protected AddFeatureStatusBase(Activity activity) {
		super(activity);
	}

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

}
