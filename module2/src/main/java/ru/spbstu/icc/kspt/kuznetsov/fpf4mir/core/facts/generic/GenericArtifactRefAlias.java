package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRefAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class GenericArtifactRefAlias implements ArtifactRefAlias {
	private RequestFact request;
	private ArtifactRef artifactRef;
	private String name;
	
	public GenericArtifactRefAlias(ArtifactRef artifactRef, RequestFact request) {
		super();
		this.request = request;
		this.artifactRef = artifactRef;
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}

	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}

	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
