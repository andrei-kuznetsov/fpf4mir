package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates.IncompatibleFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class IncompatibleFactBase<U extends FPFCloneable> extends ActivityRelatedFactBase implements IncompatibleFact<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1604031607664623320L;
	private U fact;
	

	public U getFact() {
		return fact;
	}

	public void setFact(U fact) {
		this.fact = fact;
	}

	public IncompatibleFactBase<U> reset(Activity activity, U fact){
		super.reset(activity);
		this.fact= fact;
		return this;
	}
}
