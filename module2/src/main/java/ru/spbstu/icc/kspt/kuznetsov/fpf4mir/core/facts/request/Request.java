package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public interface Request {
	public long getRefId();
	public void setRefId(long refId);
	
	public Activity getParentActivity();
}
