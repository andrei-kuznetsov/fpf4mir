package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class MvnWarn_NoFileEncoding extends ActivityRelatedFactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = -9201976275286251156L;

	public MvnWarn_NoFileEncoding(Activity build) {
		super(build);
	}

	@Override
	public String toString() {
		return "WarnNoFileEncoding [toString()=" + super.toString() + "]";
	}

}
