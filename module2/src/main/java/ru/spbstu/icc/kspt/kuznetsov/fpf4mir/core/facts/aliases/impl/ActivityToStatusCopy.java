package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Reference;

public class ActivityToStatusCopy extends ReferenceBase<ActivityRelatedFact>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -86774391630548077L;

	public ActivityToStatusCopy() {
		super();
	}

	public ActivityToStatusCopy(Activity activity, ActivityRelatedFact ua) {
		super(activity, ua);
	}

	public ActivityToStatusCopy(Activity activity,
			Reference<ActivityRelatedFact> ua) {
		super(activity, ua);
	}

	public ActivityToStatusCopy(ActivityRelatedFact ua) {
		super(ua);
	}

}
