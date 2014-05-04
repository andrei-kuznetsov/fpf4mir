package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;

public class MvnOption_PomFile extends KeyValueArgument implements MvnOption {

	public MvnOption_PomFile(BuildActivity build, MvnRootPom pom) {
		super(build, "-f", pom.getFile().getAbsolutePath());
	}
}
