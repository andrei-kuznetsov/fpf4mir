package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecutableFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class GenericExecutableFileArtifact extends ExecutableFileArtifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5873123629508056280L;

	public GenericExecutableFileArtifact() {
		super();
	}

	public GenericExecutableFileArtifact(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

}
