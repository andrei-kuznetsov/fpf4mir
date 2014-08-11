package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity;

import java.io.Serializable;
import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;

public interface Activity extends Serializable, FactWithRefId, RequestRelatedFact, FactWithName {

	@Override public Request getRequest();
	@Override public void setRequest(Request request);

	@Override public long getRefId();
	@Override public void setRefId(long refId);
	
	public Date getDate();
	public void setDate(Date date);
	
	public String getName();
	public void setName(String name);
	
	public String toShortString();
}
