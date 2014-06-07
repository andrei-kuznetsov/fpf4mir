package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityStatusRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestStatusRelatedFact;

public interface Alias<U> extends RequestRelatedFact, RequestStatusRelatedFact, ActivityStatusRelatedFact {

	@Override public RequestFact getRequest();
	@Override public void setRequest(RequestFact request);
	
	@Override public RequestStatus getRstatus();
	@Override public void setRstatus(RequestStatus rstatus);

	@Override public ActivityStatus getAstatus();
	@Override public void setAstatus(ActivityStatus astatus);
	
	public String getName();
	public void setName(String name);
	
	public U getRefObject();
	public void setRefObject(U artifact);
	
	public Alias<U> clone(RequestFact newRequest);
	public Alias<U> clone(RequestFact newRequest, String newName);

	public U cloneRefObject(Activity newActivity);
	public U cloneRefObject(Activity newActivity, String newName);
	
	public void reset(RequestStatus rstatus, U object);
	public void reset(ActivityStatus astatus, U object);
	public void reset(RequestFact request, U object);
	
	public void reset(RequestStatus rstatus, String name, U object);
	public void reset(ActivityStatus astatus, String name, U object);
	public void reset(RequestFact request, String name, U object);
	
	//public void reset(RequestFact request, RequestStatus rstatus, String name, U object);
}
