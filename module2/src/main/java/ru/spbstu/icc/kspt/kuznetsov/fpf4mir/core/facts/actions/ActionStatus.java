package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

public interface ActionStatus extends ActivityRelatedFact{

	public abstract boolean isSucceeded();

}