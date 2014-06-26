package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class FactCandidateBase<U extends FPFCloneable> extends ActivityRelatedFactBase implements FactCandidate<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4515869645109617240L;
	private U fact;
	
	@Override
	public U getFact() {
		return fact;
	}

	@Override
	public void setFact(U fact) {
		this.fact = fact;
	}
	
	public FactCandidateBase<U> reset(Activity activity, U fact){
		super.reset(activity);
		this.fact = fact;
		return this;
	}
}
