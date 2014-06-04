package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityErrorBase;

public class JavacErr_UnmappableCharacter extends ActivityErrorBase {

	public JavacErr_UnmappableCharacter(MvnBuild build, String errLine) {
		super(build, errLine);
	}
}
