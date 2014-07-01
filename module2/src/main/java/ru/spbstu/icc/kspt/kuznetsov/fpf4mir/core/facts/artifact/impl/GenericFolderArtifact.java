package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FolderArtifact;

public final class GenericFolderArtifact extends FolderArtifactBase implements FolderArtifact{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5414918216800284609L;

	public GenericFolderArtifact() {
		super();
	}

	public GenericFolderArtifact(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
	}

}
