package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;

public class GlobalFactInUseBase<U extends GlobalFact> extends ActivityRelatedFactBase implements GlobalFactInUse<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 820907614201164168L;
	
	private U fact;
	
	public GlobalFactInUseBase() {
		super();
	}

	public GlobalFactInUseBase(Activity activity, U fact) {
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
