package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildErrorIds;

public class MvnErr_UnmappableCharacter extends BuildError {

	public MvnErr_UnmappableCharacter(MvnBuild build, String errLine) {
		super(BuildErrorIds.MVN_UNMAPPABLE_CHARACTER, build, errLine);
	}
}
