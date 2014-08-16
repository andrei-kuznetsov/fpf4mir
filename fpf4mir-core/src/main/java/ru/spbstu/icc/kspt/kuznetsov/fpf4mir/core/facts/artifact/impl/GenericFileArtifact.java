package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public final class GenericFileArtifact extends FileArtifactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1506514381380985203L;

	public GenericFileArtifact() {
		super();
	}

	public GenericFileArtifact(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
	}

}
