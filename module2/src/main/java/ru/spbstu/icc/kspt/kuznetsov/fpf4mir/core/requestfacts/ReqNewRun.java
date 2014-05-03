package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class ReqNewRun extends RequestFactBase implements ReqNewActivity {
	
	private String id;

	public ReqNewRun() {
		this(false);
	}

	public ReqNewRun(boolean isTest) {
		this(isTest?R.id.TestActivity:R.id.RegularActivity);
	}
	
	public ReqNewRun(String id) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "ReqNewRun [id=" + id + "]";
	}

	@Override
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new Run(id, (int)date.getTime(), date, this);
	}
	
}
