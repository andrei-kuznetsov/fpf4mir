package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.AReference;

public final class GenericAReference extends AReferenceBase<ActivityRelatedFact> implements AReference<ActivityRelatedFact> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7957775895428767263L;

	public GenericAReference() {
		super();
	}

	public GenericAReference(Activity activity, ActivityRelatedFact ua) {
		super(activity, ua);
	}

	public GenericAReference(Activity activity, AReference<ActivityRelatedFact> ua) {
		super(activity, ua);
	}

	public GenericAReference(ActivityRelatedFact ua) {
		super(ua);
	}

}
