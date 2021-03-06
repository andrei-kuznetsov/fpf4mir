package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatusRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatusRelatedFact;

public interface Alias<U extends ActivityRelatedFact> extends RequestRelatedFact, ActivityRelatedFact, RequestStatusRelatedFact, ActivityStatusRelatedFact {

	@Override public Request getRequest();
	@Override public void setRequest(Request request);
	
	@Override public RequestStatus getRstatus();
	@Override public void setRstatus(RequestStatus rstatus);

	@Override public ActivityStatus getAstatus();
	@Override public void setAstatus(ActivityStatus astatus);

	@Override public Activity getActivity();
	@Override public void setActivity(Activity astatus);
	
	public String getName();
	public void setName(String name);
	
	public U getRefObject();
	public void setRefObject(U artifact);
	
	public Alias<U> clone(Request newRequest);
	public Alias<U> clone(Request newRequest, String newName);

	public U cloneRefObject(Activity newActivity);
	public U cloneRefObject(Activity newActivity, String newName);
}
