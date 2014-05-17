package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public interface RequestSubstatus {

	public abstract RequestFact getRequest();

	public abstract void setRequest(RequestFact mainStatus);

}