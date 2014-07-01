package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.FolderArtifactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFolderArtifact;

public class TmpDirRoot extends FolderArtifactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4897688847520902792L;

	public TmpDirRoot(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

	public FolderArtifact newTempFolder(Activity activity){
		return new GenericFolderArtifact(activity, getAbsolutePath(), UUID.randomUUID().toString());
	}
}
