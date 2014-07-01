package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public interface DownloadStatus extends ActionStatus {
	
	public Artifact getDownloadedArtifact();
	public void setDownloadedArtifact(Artifact downloadedArtifact);

	public ArtifactRef getArtifactRef();
	public void setArtifactRef(ArtifactRef artifactRef);
	
	public int getStatus();
	public void setStatus(int status);
}
