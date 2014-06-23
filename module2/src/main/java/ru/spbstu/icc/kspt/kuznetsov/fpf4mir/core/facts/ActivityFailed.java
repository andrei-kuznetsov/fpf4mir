package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public interface ActivityFailed extends ActivityFinalStatus {
	public String getMessage();
	public String getType();
}
