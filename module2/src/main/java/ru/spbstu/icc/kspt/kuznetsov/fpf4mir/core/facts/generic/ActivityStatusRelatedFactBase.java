package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityStatusRelatedFact;

public class ActivityStatusRelatedFactBase implements ActivityStatusRelatedFact{
	private ActivityStatus astatus;

	public ActivityStatus getAstatus() {
		return astatus;
	}

	public void setAstatus(ActivityStatus astatus) {
		this.astatus = astatus;
	}
	
}
