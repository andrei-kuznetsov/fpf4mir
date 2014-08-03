package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.RequestRelatedFactBase;

public class RestArtifact extends RequestRelatedFactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7901890687078124213L;

	private Artifact artifact;
	
	public RestArtifact() {
		super();
	}

	public RestArtifact(ReqRestCommand restCmd, Artifact artifact) {
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
