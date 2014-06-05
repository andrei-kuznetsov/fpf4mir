package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class FolderArtifactBase extends FolderArtifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6396755647341759555L;

	public FolderArtifactBase() {
		super();
	}

	public FolderArtifactBase(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

}
