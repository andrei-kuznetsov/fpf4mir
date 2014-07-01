package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ExecutableFileArtifact;

public final class GenericExecutableFileArtifact extends ExecutableFileArtifactBase implements ExecutableFileArtifact{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5524226625300310804L;

	public GenericExecutableFileArtifact() {
		super();
	}

	public GenericExecutableFileArtifact(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
	}

	public GenericExecutableFileArtifact(Artifact other) {
		super(other);
	}

}
