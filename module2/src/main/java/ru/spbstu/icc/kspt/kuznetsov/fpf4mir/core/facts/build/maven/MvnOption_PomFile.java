package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;

public class MvnOption_PomFile extends KeyValueArgument implements MvnOption {

	public MvnOption_PomFile(Activity build, FileArtifact pom) {
		super(build, "-f", pom.getAbsolutePath());
	}
}
