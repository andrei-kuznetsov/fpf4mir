package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RequestScopedKnowledge;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public interface IncompatibleFactCandidate<U extends FPFCloneable> extends RequestScopedKnowledge{
	public U getFact();
	
	public FactCandidate<U> getFactCandidate();
	public void setFactCandidate(FactCandidate<U> candidate);
}
