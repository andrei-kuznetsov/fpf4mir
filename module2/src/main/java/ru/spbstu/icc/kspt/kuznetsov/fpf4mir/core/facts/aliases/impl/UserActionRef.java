package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.AReference;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public final class UserActionRef extends AReferenceBase<UserAction> implements ActivityRelatedFact, FactWithName {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396999422454474582L;

	public UserActionRef() {
		super();
	}

	public UserActionRef(Activity activity, AReference<UserAction> ua) {
		super(activity, ua);
	}

	public UserActionRef(Activity activity, UserAction ua) {
		super(activity, ua);
	}

	public UserActionRef(UserAction ua) {
		super(ua);
	}
	
}
