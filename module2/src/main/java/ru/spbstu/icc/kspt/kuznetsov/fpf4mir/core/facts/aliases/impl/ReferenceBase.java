package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.Reference;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

public class ReferenceBase<U extends ActivityRelatedFact> extends ActivityRelatedFactBase implements Reference<U> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396999422454474582L;
	
	private U refObject;
	private String name = getClass().getSimpleName();
	
	protected ReferenceBase() {
		super();
	}

	protected ReferenceBase(U ua) {
		this(ua.getActivity(), ua);
	}
	
	
	protected ReferenceBase(Activity activity, U ua) {
		super(activity);
		refObject = ua;
	}

	protected ReferenceBase(Activity activity, Reference<U> ua) {
		super();
		refObject = ua.getRefObject();
	}

	public U getRefObject() {
		return refObject;
	}

	public void setRefObject(U refObject) {
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
	
	public Reference<U> reset(Activity activity, U refObject){
		super.reset(activity);
		this.refObject = refObject;
		return this;
	}
}
