package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityErrorBase;

public class JavacErr_UnmappableCharacter extends ActivityErrorBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5220875601056863114L;

	public JavacErr_UnmappableCharacter(Activity build, String errLine) {
		super(build, errLine);
	}
}
