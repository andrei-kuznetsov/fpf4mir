package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.AReference;

public class ActivityToStatusCopy extends AReferenceBase<ActivityRelatedFact>{

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
			AReference<ActivityRelatedFact> ua) {
		super(activity, ua);
	}

	public ActivityToStatusCopy(ActivityRelatedFact ua) {
		super(ua);
	}

}
