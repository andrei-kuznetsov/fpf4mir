package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.deploy;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;

public class DeployFolder implements FolderArtifactAlias{
	FolderArtifact folder;

	public DeployFolder(FolderArtifact folder) {
		super();
		this.folder = folder;
	}

	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}
}
