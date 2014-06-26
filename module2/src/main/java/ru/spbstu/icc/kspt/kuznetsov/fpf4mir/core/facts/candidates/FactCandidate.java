package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;


public interface FactCandidate<U extends FPFCloneable> extends ActivityRelatedFact {
	public U getFact();
	public void setFact(U fact);
}
