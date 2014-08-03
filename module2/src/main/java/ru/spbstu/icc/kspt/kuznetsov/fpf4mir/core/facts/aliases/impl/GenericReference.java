package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Reference;

public final class GenericReference extends ReferenceBase<ActivityRelatedFact> implements Reference<ActivityRelatedFact> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7957775895428767263L;

	public GenericReference() {
		super();
	}

	public GenericReference(Activity activity, ActivityRelatedFact ua) {
		super(activity, ua);
	}

	public GenericReference(Activity activity, Reference<ActivityRelatedFact> ua) {
		super(activity, ua);
	}

	public GenericReference(ActivityRelatedFact ua) {
		super(ua);
	}

}
