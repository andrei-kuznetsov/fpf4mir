package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Alias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class AliasBase <U extends FPFCloneable> implements Alias<U>, FPFCloneable{
	private U refObject;
	private RequestFact request;
	private RequestStatus rstatus;
	private String name;
	
	public U getRefObject() {
		return refObject;
	}
	
	public void setRefObject(U object) {
		this.refObject = object;
	}
	
	public RequestFact getRequest() {
		return request;
	}
	
	public void setRequest(RequestFact request) {
		this.request = request;
	}
	
	public RequestStatus getRstatus() {
		return rstatus;
	}
	
	public void setRstatus(RequestStatus rstatus) {
		this.rstatus = rstatus;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Alias<U> clone(RequestFact newRequest) {
		Alias<U> copy;
		try {
			copy = (Alias<U>)this.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		copy.setRequest(newRequest);
		return copy;
	}
	
	@Override
	public Alias<U> clone(RequestFact newRequest, String newName) {
		Alias<U> copy = this.clone(newRequest);
		copy.setName(newName);
		return copy;
	}

	@Override
	public U cloneRefObject(Activity newActivity) {
		U copy;
		try {
			copy = (U)refObject.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		((ActivityRelatedFact)copy).setActivity(newActivity);
		return copy;
	}

	@Override
	public U cloneRefObject(Activity newActivity, String newName) {
		U copy = this.cloneRefObject(newActivity);
		((FactWithName)copy).setName(newName);
		return copy;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public void reset(RequestStatus rstatus, U object) {
		this.reset(rstatus, ((FactWithName)object).getName(), object);
	}

	@Override
	public void reset(RequestStatus rstatus, String name, U object) {
		this.reset(null, rstatus, name, object);
	}

	@Override
	public void reset(RequestFact request, String name, U object) {
		this.reset(request, null, name, object);
	}

	@Override
	public void reset(RequestFact request, U object) {
		final String name = ((FactWithName)object).getName();
		this.reset(request, null, name, object);
	}
	
	@Override
	public void reset(RequestFact request, RequestStatus rstatus, String name,
			U object) {
		this.refObject = object;
		this.rstatus = rstatus;
		this.request = request;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [object=" + refObject + ", request=" + request
				+ ", rstatus=" + rstatus + ", name=" + name + "]";
	}

}
