package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class TmpDirRoot extends FolderArtifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4897688847520902792L;

	public TmpDirRoot(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

	public FolderArtifact newTempFolder(Activity activity){
		return new FolderArtifact(activity, getAbsolutePath(), UUID.randomUUID().toString());
	}
}
