package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;

public interface Action<T extends ActivityRelatedFact> extends ActivityRelatedFact {
	public void setParameter(T param);
	public T getParameter();
}
