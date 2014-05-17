package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public interface ReqNewActivity extends RequestFact {
	public Activity newActivityInstance();
	public String getActivityName();
}
