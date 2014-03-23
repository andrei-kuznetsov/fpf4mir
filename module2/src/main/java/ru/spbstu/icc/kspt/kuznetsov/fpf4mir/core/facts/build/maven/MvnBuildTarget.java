package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;


public interface MvnBuildTarget {
	public MvnOption createMvnOption(Build build);
}
