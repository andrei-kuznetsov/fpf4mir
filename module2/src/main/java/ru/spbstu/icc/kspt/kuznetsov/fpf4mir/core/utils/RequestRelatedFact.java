package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public interface RequestRelatedFact {
	public RequestFact getRequest();
	public void setRequest(RequestFact activity);
}