package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ExecutableFileArtifact;

public class ExecutableFileArtifactBase extends FileArtifactBase implements ExecutableFileArtifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 999679136593001316L;

	protected ExecutableFileArtifactBase() {
		super();
	}

	protected ExecutableFileArtifactBase(Activity activity, String baseDir,
			String fileName) {
		super(activity, baseDir, fileName);
	}

	protected ExecutableFileArtifactBase(Artifact other) {
		super(other);
	}

}
