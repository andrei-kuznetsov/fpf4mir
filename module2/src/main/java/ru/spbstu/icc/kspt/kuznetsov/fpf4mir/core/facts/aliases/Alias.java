package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResultRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatusRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatusRelatedFact;

public interface Alias<U> extends RequestRelatedFact, RequestStatusRelatedFact, ActivityStatusRelatedFact, ActivityResultRelatedFact {

	@Override public RequestFact getRequest();
	@Override public void setRequest(RequestFact request);
	
	@Override public RequestStatus getRstatus();
	@Override public void setRstatus(RequestStatus rstatus);

	@Override public ActivityStatus getAstatus();
	@Override public void setAstatus(ActivityStatus astatus);
	

	@Override public ActivityResult getAresult();
	@Override public void setAresult(ActivityResult astatus);
	
	public String getName();
	public void setName(String name);
	
	public U getRefObject();
	public void setRefObject(U artifact);
	
	public Alias<U> clone(RequestFact newRequest);
	public Alias<U> clone(RequestFact newRequest, String newName);

	public U cloneRefObject(Activity newActivity);
	public U cloneRefObject(Activity newActivity, String newName);
}
