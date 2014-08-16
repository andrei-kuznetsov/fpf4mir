package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;


public interface FactCandidate<U extends ActivityRelatedFact> extends ActivityRelatedFact {
	public U getFact();
	public void setFact(U fact);
}
