package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;

public class ReqNewBuild implements ReqNewActivity{
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof ReqNewBuild) && super.equals(obj);
	}

	@Override
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new Build((int)date.getTime(), date, this);
	}

	@Override
	public String toString() {
		return "ReqNewBuild []";
	}
}
