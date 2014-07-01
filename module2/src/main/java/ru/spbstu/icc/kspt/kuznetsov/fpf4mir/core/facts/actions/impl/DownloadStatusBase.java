package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class DownloadStatusBase extends ActionStatusBase implements DownloadStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6609622512123609004L;
	private ArtifactRef artifactRef;
	private Artifact downloadedArtifact;
	private int status;
	
	protected DownloadStatusBase(Activity activity, ArtifactRef artifactRef, int status) {
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
