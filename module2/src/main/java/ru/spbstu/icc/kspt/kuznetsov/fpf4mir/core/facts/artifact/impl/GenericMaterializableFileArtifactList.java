package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.MaterializableFileArtifactList;

public final class GenericMaterializableFileArtifactList extends MaterializableFileArtifactListBase implements MaterializableFileArtifactList{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2319655169447952753L;

	public GenericMaterializableFileArtifactList() {
		super();
	}

	public GenericMaterializableFileArtifactList(Activity activity,
			FolderArtifact baseDir, String pattern, FolderArtifact tmpDir) {
		super(activity, baseDir, pattern, tmpDir);
	}

}
