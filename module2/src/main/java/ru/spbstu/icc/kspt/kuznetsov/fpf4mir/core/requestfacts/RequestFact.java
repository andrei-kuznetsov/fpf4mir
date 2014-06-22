package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public interface RequestFact {
	public long getRefId();
	public void setRefId(long refId);
	
	public Activity getParentActivity();
}
