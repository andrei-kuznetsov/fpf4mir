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
	
	public ArtifactAliasBase(RequestFact request, String name) {
		super();
		this.request = request;
		this.name = name;
	}

	public ArtifactAliasBase(RequestStatus rstatus, String name) {
		super();
		this.rstatus = rstatus;
		this.name = name;
	}

	public ArtifactAliasBase(RequestFact request, ArtifactAlias artifactAlias) {
		super();
		this.request = request;
		this.name = artifactAlias.getName();
	}

	public ArtifactAliasBase(RequestStatus rstatus, ArtifactAlias artifactAlias) {
		super();
		this.rstatus = rstatus;
		this.name = artifactAlias.getName();
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
