package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;

public class DownloadStatus extends ActionStatusBase implements ActionStatus {
	private ArtifactRef artifactRef;
	private Artifact downloadedArtifact;
	private int status;
	
	public DownloadStatus(Activity activity, ArtifactRef artifactRef, int status) {
		super(activity);
		this.status = status;
		this.artifactRef = artifactRef;
		
		this.status = status;
	}
	
	public Artifact getDownloadedArtifact() {
		return downloadedArtifact;
	}

	public void setDownloadedArtifact(Artifact downloadedArtifact) {
		this.downloadedArtifact = downloadedArtifact;
	}

	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}
	
	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}
	
	public int getStatus() {
		return status;
	}
	
	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public boolean isSucceeded() {
		return 200 <= status && status < 300;
	}
}
