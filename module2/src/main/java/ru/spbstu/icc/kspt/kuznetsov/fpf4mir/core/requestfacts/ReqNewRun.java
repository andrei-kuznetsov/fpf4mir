package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;

public class ReqNewRun extends RequestFactBase implements ReqNewActivity {
	private String id;
	
	public ReqNewRun(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	public ReqNewRun(Activity parentActivity) {
		this(false, parentActivity);
	}

	public ReqNewRun(boolean isTest, Activity parentActivity) {
		this(isTest?R.id.TestActivity:R.id.RegularActivity, parentActivity);
	}
	
	public ReqNewRun(String id, Activity parentActivity) {
		super(parentActivity);
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
	public String getActivityName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
