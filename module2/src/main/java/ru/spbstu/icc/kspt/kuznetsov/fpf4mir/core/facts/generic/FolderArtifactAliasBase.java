package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class FolderArtifactAliasBase extends ArtifactAliasBase implements FolderArtifactAlias{
	private FolderArtifact folder;
	
	public FolderArtifactAliasBase(RequestFact request, String name,
			FolderArtifact folder) {
		super(request, name);
		this.folder = folder;
	}

	public FolderArtifactAliasBase(RequestFact request, FolderArtifactAlias folder) {
		super(request, folder);
		this.folder = folder.getFolder();
	}
	
	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}

}
