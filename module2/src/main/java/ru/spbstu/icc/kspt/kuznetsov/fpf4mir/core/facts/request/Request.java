package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;

public interface Request extends ActivityRelatedFact{
	public long getRefId();
	public void setRefId(long refId);
}
