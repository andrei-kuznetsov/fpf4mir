package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;


public interface ArtifactRefAlias extends ArtifactAlias{

	public ArtifactRef getArtifactRef();
	public void setArtifactRef(ArtifactRef artifactRef);

	public ArtifactRef cloneArtifact(Activity newActivity);
	public ArtifactRef cloneArtifact(Activity newActivity, String newName);
}
