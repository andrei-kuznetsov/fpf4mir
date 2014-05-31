package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public interface RequestStatusRelatedFact {
	public RequestStatus getRstatus();
	public void setRstatus(RequestStatus rstatus);
}
