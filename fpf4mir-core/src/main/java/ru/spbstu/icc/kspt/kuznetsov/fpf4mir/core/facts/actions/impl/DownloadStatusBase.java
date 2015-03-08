package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class DownloadStatusBase extends ActionStatusBase<ArtifactRef> implements DownloadStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6609622512123609004L;
	private Artifact downloadedArtifact;
	private int status;
	
	protected DownloadStatusBase(Activity activity, ArtifactRef artifactRef, int status, Artifact downloadedArtifact) {
		super(activity, artifactRef);
		this.status = status;
		this.downloadedArtifact = downloadedArtifact;
	}
	
	public Artifact getDownloadedArtifact() {
		return downloadedArtifact;
	}

	public void setDownloadedArtifact(Artifact downloadedArtifact) {
		this.downloadedArtifact = downloadedArtifact;
	}

	public ArtifactRef getArtifactRef() {
		return getParameter();
	}
	
	public void setArtifactRef(ArtifactRef artifactRef) {
		setParameter(artifactRef);
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
