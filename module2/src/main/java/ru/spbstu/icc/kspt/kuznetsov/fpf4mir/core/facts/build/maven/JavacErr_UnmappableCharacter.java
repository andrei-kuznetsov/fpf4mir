package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildError;

public class JavacErr_UnmappableCharacter extends BuildError {

	public JavacErr_UnmappableCharacter(MvnBuild build, String errLine) {
		super(build, errLine);
	}
}
