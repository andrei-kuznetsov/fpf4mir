package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;



public class MvnBuildTarget_Clean extends ActivityRelatedFactBase implements MvnBuildTarget{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7839731904073818024L;

	@Override
	public MvnOption createMvnOption(Activity build) {
		return new MvnOption_TgtClean(build);
	}
}
