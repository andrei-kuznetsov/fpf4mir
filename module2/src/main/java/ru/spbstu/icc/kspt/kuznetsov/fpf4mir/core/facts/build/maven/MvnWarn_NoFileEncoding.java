package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildFact;

public class MvnWarn_NoFileEncoding extends BuildFact {

	public MvnWarn_NoFileEncoding(MvnBuild build) {
		super(build);
	}

	@Override
	public String toString() {
		return "WarnNoFileEncoding [toString()=" + super.toString() + "]";
	}

}
