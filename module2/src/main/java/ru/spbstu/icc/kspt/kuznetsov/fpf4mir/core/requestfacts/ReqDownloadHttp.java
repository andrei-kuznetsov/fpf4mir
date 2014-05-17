package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;

public class ReqDownloadHttp extends RequestFactBase implements RequestFact {
	private ArtifactRef artifactRef;

	public ReqDownloadHttp(Activity activity, ArtifactRef artifactRef) {
		super(activity);
		this.artifactRef = artifactRef;
	}

	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}

	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}
	
}
