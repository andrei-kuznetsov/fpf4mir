package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;



public interface FolderArtifactAlias extends ArtifactAlias {

	public abstract FolderArtifact getFolder();
	public abstract void setFolder(FolderArtifact folder);

	public FolderArtifact cloneArtifact(Activity newActivity);
	public FolderArtifact cloneArtifact(Activity newActivity, String newName);
}