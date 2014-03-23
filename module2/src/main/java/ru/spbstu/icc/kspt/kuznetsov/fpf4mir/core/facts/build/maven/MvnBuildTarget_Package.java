package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;



public class MvnBuildTarget_Package implements MvnBuildTarget{
	
	@Override
	public MvnOption createMvnOption(Build build) {
		return new MvnOption_TgtPackage(build);
	}
}
