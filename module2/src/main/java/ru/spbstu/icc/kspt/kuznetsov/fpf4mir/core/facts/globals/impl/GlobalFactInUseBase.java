package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.GlobalFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.GlobalFactInUse;

public class GlobalFactInUseBase<U extends GlobalFact> extends ActivityRelatedFactBase implements GlobalFactInUse<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 820907614201164168L;
	
	private U fact;
	
	protected GlobalFactInUseBase() {
		super();
	}

	protected GlobalFactInUseBase(Activity activity, U fact) {
		super(activity);
		this.fact = fact;
	}

	@Override
	public U getFact() {
		return fact;
	}

	public void setFact(U fact) {
		this.fact = fact;
	}

	public GlobalFactInUseBase<U> reset(Activity activity, U fact){
		super.reset(activity);
		this.fact = fact;
		return this;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [global=" + fact + "]";
	}
	
}
