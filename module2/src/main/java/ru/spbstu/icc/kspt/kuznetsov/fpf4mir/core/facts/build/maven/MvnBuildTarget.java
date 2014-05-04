package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;


public interface MvnBuildTarget {
	public MvnOption createMvnOption(BuildActivity build);
}
