package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity;

import java.io.Serializable;
import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public interface Activity extends Serializable, FactWithRefId, RequestRelatedFact {

	@Override public RequestFact getRequest();
	@Override public void setRequest(RequestFact request);

	@Override public long getRefId();
	@Override public void setRefId(long refId);
	
	public Date getDate();
	public void setDate(Date date);
	
	public String getId();
	public void setId(String id);
	
	public String toShortString();
}
