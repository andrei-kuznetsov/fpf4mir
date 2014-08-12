package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases.AReference;

public class AReferenceBase<U extends ActivityRelatedFact> extends ActivityRelatedFactBase implements AReference<U> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396999422454474582L;
	
	private U refObject;
	private String name = getClass().getSimpleName();
	
	protected AReferenceBase() {
		super();
	}

	protected AReferenceBase(U ua) {
		this(ua.getActivity(), ua);
	}
	
	
	protected AReferenceBase(Activity activity, U ua) {
		super(activity);
		refObject = ua;
	}

	protected AReferenceBase(Activity activity, AReference<U> ua) {
		this(activity, ua.getRefObject());
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
	
	public AReference<U> reset(Activity activity, U refObject){
		super.reset(activity);
		this.refObject = refObject;
		return this;
	}
}
