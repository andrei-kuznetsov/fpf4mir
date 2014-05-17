package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;



public interface FileArtifactAlias extends ArtifactAlias {

	public abstract FileArtifact getFile();
	public abstract void setFile(FileArtifact file);

}