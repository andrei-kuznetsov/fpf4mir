package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;



public class MvnBuildTarget_Clean implements MvnBuildTarget{

	@Override
	public MvnOption createMvnOption(BuildActivity build) {
		return new MvnOption_TgtClean(build);
	}
}
