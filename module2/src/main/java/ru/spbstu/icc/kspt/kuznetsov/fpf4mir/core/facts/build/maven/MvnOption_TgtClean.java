package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class MvnOption_TgtClean extends OrdinalArgument implements MvnOption {
	public MvnOption_TgtClean(Build build) {
		super(build, MvnR.order.tgt_clean, "clean");
	}
}
