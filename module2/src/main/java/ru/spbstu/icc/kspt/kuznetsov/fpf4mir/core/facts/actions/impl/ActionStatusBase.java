package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;

public abstract class ActionStatusBase extends ActivityRelatedFactBase implements ActionStatus, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3231409981740220661L;

	public ActionStatusBase() {
		super();
	}

	public ActionStatusBase(Activity activity) {
		super(activity);
	}
	
}
