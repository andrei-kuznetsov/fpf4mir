package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecutableFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecutableFileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;

public class JavaRunExecutableArtifact extends ExecutableFileArtifact {


	/**
	 * 
	 */
	private static final long serialVersionUID = -3533189526254970312L;

	public JavaRunExecutableArtifact(Activity parentActivity,
			ExecutableFileArtifact file) {
		super(parentActivity, file);
	}

	public JavaRunExecutableArtifact(Activity parentActivity,
			ExecutableFileArtifactAlias artifactAlias) {
		super(parentActivity, artifactAlias);
	}

	public JavaRunExecutableArtifact(Activity parentActivity, FileArtifact file) {
		super(parentActivity, file);
	}

	public JavaRunExecutableArtifact(Activity parentActivity, File file) {
		super(parentActivity, file);
	}
	
	@Override
	public String toString() {
		return "JavaRunExecutableArtifact [toString()=" + super.toString()
				+ "]";
	}

}
