package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public abstract class ArtifactAliasBase implements ArtifactAlias, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1895194686706627664L;
	
	private RequestFact request;
	private RequestStatus rstatus;
	private String name;
	

	public void reset(RequestFact request, RequestStatus rstatus, String name) {
		this.request = request;
		this.rstatus = rstatus;
		this.name = name;
	}
	
	public void reset(RequestFact request, String name) {
		this.reset(request, null, name);
	}

	public void reset(RequestStatus rstatus, String name) {
		this.reset(null, rstatus, name);
	}

	public void reset(RequestFact request, ArtifactAlias artifactAlias) {
		this.reset(request, artifactAlias.getName());
	}

	public void reset(RequestStatus rstatus, ArtifactAlias artifactAlias) {
		this.reset(rstatus, artifactAlias.getName());
	}
	
	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public ArtifactAlias clone(RequestFact newRequest) {
		ArtifactAlias copy = org.apache.commons.lang3.SerializationUtils.clone(this);
		copy.setRequest(newRequest);
		return copy;
	}
	
	public RequestStatus getRstatus() {
		return rstatus;
	}

	public void setRstatus(RequestStatus rstatus) {
		this.rstatus = rstatus;
	}

	@Override
	public ArtifactAlias clone(RequestFact newRequest, String newName) {
		ArtifactAlias copy = org.apache.commons.lang3.SerializationUtils.clone(this);
		copy.setRequest(newRequest);
		copy.setName(newName);
		return copy;
	}

}
