package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;



public class MvnBuildTarget_Package implements MvnBuildTarget{
	
	@Override
	public MvnOption createMvnOption(Activity build) {
		return new MvnOption_TgtPackage(build);
	}
}
