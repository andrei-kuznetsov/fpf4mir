package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;

public class RestArtifact extends RestRequestRelatedFactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7901890687078124213L;

	private Artifact artifact;
	
	public RestArtifact() {
		super();
	}

	public RestArtifact(RestRequestCommand restCmd, Artifact artifact) {
		super(restCmd);
		this.artifact = artifact;
	}

	public Artifact getArtifact() {
		return artifact;
	}

	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}

}
