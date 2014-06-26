package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;



public class MvnBuildTarget_Package extends ActivityRelatedFactBase implements MvnBuildTarget{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6249971752212657934L;

	@Override
	public MvnOption createMvnOption(Activity build) {
		return new MvnOption_TgtPackage(build);
	}
}
