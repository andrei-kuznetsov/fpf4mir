package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class MvnOption_TgtPackage extends OrdinalArgument implements MvnOption {
	public MvnOption_TgtPackage(Build build) {
		super(build, MvnR.order.tgt_package, "package");
	}
}