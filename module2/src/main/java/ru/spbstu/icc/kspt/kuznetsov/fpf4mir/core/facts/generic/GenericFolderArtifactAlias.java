package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class GenericFolderArtifactAlias extends FolderArtifactAliasBase implements FolderArtifactAlias{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4110010390458915773L;

	public GenericFolderArtifactAlias(RequestFact request, String name,
			FolderArtifact folder) {
		super(request, name, folder);
	}

	public GenericFolderArtifactAlias(RequestFact request, FolderArtifact folder) {
		this(request, "GenericFolderArtifactAlias", folder);
	}
	
	public GenericFolderArtifactAlias(RequestFact request, FolderArtifactAlias folder) {
		super(request, folder);
	}
}
