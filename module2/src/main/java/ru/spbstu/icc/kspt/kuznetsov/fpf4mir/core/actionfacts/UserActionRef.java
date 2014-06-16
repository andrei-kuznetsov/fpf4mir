package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public final class UserActionRef extends ActivityRelatedFactBase implements ActivityRelatedFact, FactWithName {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396999422454474582L;
	
	private UserAction refObject;
	private String name = getClass().getSimpleName();
	
	public UserActionRef() {
		super();
	}

	public UserActionRef(UserAction ua) {
		this(ua.getActivity(), ua);
	}
	
	
	public UserActionRef(Activity activity, UserAction ua) {
		super(activity);
		refObject = ua;
	}

	public UserActionRef(Activity activity, UserActionRef ua) {
		super();
		refObject = ua.refObject;
	}

	public UserAction getRefObject() {
		return refObject;
	}

	public void setRefObject(UserAction refObject) {
		this.refObject = refObject;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [refObject=" + refObject + "]";
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
}
