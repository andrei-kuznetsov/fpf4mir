package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

public interface ActivityErrorFixed extends ActivityRelatedFact{
	
	public ActivityError getError();
	public void setError(ActivityError error);

}
