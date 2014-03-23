package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;

public class MvnOption_PomFile extends KeyValueArgument implements MvnOption {

	public MvnOption_PomFile(Build build, MvnRootPom pom) {
		super(build, "-f", pom.getFile().getAbsolutePath());
	}
}
