package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.candidates;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestScopedKnowledge;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public interface IncompatibleFact<U extends FPFCloneable> extends RequestScopedKnowledge{
	public U getFact();
	public void setFact(U fact);
}
