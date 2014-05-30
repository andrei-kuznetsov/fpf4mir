package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public interface Alias<U> {

	public RequestFact getRequest();
	public void setRequest(RequestFact request);

	public RequestStatus getRstatus();
	public void setRstatus(RequestStatus request);
	
	public String getName();
	public void setName(String name);
	
	public U getRefObject();
	public void setRefObject(U artifact);
	
	public Alias<U> clone(RequestFact newRequest);
	public Alias<U> clone(RequestFact newRequest, String newName);

	public U cloneRefObject(Activity newActivity);
	public U cloneRefObject(Activity newActivity, String newName);
	
	public void reset(RequestStatus rstatus, U object);;
	public void reset(RequestFact request, U object);
	
	public void reset(RequestStatus rstatus, String name, U object);
	public void reset(RequestFact request, String name, U object);
	
	public void reset(RequestFact request, RequestStatus rstatus, String name, U object);
}
