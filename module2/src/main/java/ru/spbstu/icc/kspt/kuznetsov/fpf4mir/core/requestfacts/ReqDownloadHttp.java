package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;

public class ReqDownloadHttp extends RequestFactBase implements RequestFact {
	private ArtifactRef artifactRef;

	public ReqDownloadHttp(ArtifactRef artifactRef) {
		super(artifactRef.getActivity());
		this.artifactRef = artifactRef;
	}

	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}

	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}
	
}
