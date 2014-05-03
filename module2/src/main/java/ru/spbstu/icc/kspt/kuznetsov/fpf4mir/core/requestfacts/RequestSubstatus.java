package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public interface RequestSubstatus {

	public abstract RequestStatus getMainStatus();

	public abstract void setMainStatus(RequestStatus mainStatus);

}