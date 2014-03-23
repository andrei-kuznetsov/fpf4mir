package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunExecutableArtifact;

public class JavaRunExecutableArtifact extends RunExecutableArtifact {

	public JavaRunExecutableArtifact(File file, File workingDir) {
		super(file, workingDir);
	}

	public JavaRunExecutableArtifact(File file) {
		super(file);
	}

	@Override
	public String toString() {
		return "JavaRunExecutableArtifact [toString()=" + super.toString()
				+ "]";
	}

}
