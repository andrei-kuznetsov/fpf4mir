package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class ArtifactAliasBase implements ArtifactAlias{
	private RequestFact request;
	private String name;
	
	public ArtifactAliasBase(RequestFact request, String name) {
		super();
		this.request = request;
		this.name = name;
	}

	public ArtifactAliasBase(RequestFact request, ArtifactAlias artifactAlias) {
		super();
		this.request = request;
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
	
	
}
