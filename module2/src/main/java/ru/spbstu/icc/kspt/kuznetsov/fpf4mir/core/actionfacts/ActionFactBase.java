package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class ActionFactBase extends ActivityRelatedFactBase implements ActionFact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2616511145672466780L;

	public ActionFactBase() {
		super();
	}

	public ActionFactBase(Activity activity) {
		super(activity);
	}
	
}
