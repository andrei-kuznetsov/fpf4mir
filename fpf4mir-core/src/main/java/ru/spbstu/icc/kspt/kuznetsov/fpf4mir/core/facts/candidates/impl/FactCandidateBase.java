package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates.FactCandidate;

public class FactCandidateBase<U extends ActivityRelatedFact> extends ActivityRelatedFactBase implements FactCandidate<U>{
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
