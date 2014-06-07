package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;

public interface ActivityStatusRelatedFact {
	public ActivityStatus getAstatus();
	public void setAstatus(ActivityStatus astatus);
}
