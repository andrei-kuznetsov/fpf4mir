package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Alias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class AliasBase <U extends FPFCloneable> implements Alias<U>, FPFCloneable, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1936012869829532600L;
	
	private U refObject;
	private RequestFact request;
	private RequestStatus rstatus;
	private ActivityStatus astatus;
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
	
	public ActivityStatus getAstatus() {
		return astatus;
	}

	public void setAstatus(ActivityStatus astatus) {
		this.astatus = astatus;
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

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	public AliasBase<U> reset(RequestStatus rstatus, U object) {
		this.reset(rstatus, ((FactWithName)object).getName(), object);
		return this;
	}

	public AliasBase<U> reset(RequestStatus rstatus, String name, U object) {
		this.reset(null, rstatus, null, name, object);
		return this;
	}

	public AliasBase<U> reset(ActivityStatus astatus, U object) {
		if (object instanceof FactWithName){
			this.reset(astatus, ((FactWithName)object).getName(), object);
		} else {
			this.reset(astatus, "<no name>", object);
		}
		return this;
	}

	public AliasBase<U> reset(ActivityStatus astatus, String name, U object) {
		this.reset(null, null, astatus, name, object);
		return this;
	}
	
	public AliasBase<U> reset(RequestFact request, String name, U object) {
		this.reset(request, null, null, name, object);
		return this;
	}

	public AliasBase<U> reset(RequestFact request, U object) {
		final String name;
		if (object instanceof FactWithName){
			name = ((FactWithName)object).getName();
		} else {
			name = "<no name>";
		}

		return this.reset(request, null, null, name, object);
	}
	
	public AliasBase<U> reset(RequestFact request, RequestStatus rstatus, ActivityStatus astatus, String name,
			U object) {
		this.refObject = object;
		this.rstatus = rstatus;
		this.request = request;
		this.astatus = astatus;
		this.name = name;
		return this;
	}

	public AliasBase<U> reset(RequestStatus rstatus, Alias<U> alias) {
		this.reset(rstatus, alias.getName(), alias.getRefObject());
		return this;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder(getClass().getSimpleName() + " [object=" + refObject);
		if (request != null) sb.append(", request=" + request);
		if (rstatus != null) sb.append(", rstatus=" + rstatus);
		if (astatus != null) sb.append(", astatus=" + astatus);
		if (name != null) sb.append(", name=" + name);
		
		sb.append("]");
		
		return sb.toString();
	}

}
