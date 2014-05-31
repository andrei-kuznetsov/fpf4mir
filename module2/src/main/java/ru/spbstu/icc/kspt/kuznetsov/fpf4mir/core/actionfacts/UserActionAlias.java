package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.AliasBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

public final class UserActionAlias extends AliasBase<UserAction> implements ActivityRelatedFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6396999422454474582L;
	
	private Activity activity;
	
	public UserActionAlias() {
		super();
	}

	public UserActionAlias(Activity activity, UserAction ua) {
		super();
		this.activity = activity;
		this.setRefObject(ua);
	}

	public UserActionAlias(Activity activity, UserActionAlias ua) {
		super();
		this.activity = activity;
		this.setRefObject(ua.getRefObject());
	}

	public UserActionAlias(RequestStatus rstatus, UserActionAlias ua) {
		super();
		this.setRstatus(rstatus);
		this.setRefObject(ua.getRefObject());
	}
	
	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

}
