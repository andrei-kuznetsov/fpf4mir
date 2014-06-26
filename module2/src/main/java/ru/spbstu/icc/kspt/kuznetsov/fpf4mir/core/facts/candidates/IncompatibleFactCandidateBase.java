package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class IncompatibleFactCandidateBase<U extends FPFCloneable> extends ActivityRelatedFactBase implements IncompatibleFactCandidate<U>{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1604031607664623320L;
	private FactCandidate<U> factCandidate;
	
	@Override
	public U getFact() {
		return this.factCandidate==null?null:this.factCandidate.getFact();
	}

	@Override
	public FactCandidate<U> getFactCandidate() {
		return factCandidate;
	}

	@Override
	public void setFactCandidate(FactCandidate<U> factCandidate) {
		this.factCandidate = factCandidate;
	}

	public IncompatibleFactCandidateBase<U> reset(Activity activity, FactCandidate<U> factCandidate){
		super.reset(activity);
		this.factCandidate = factCandidate;
		return this;
	}
}
