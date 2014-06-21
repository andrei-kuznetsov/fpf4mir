package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class GenericFolderArtifact extends FolderArtifact{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4444718160705610319L;

	public GenericFolderArtifact() {
		super();
	}

	public GenericFolderArtifact(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
	}
}
