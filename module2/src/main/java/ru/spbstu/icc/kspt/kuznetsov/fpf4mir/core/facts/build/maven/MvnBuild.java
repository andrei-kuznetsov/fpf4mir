package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class MvnBuild extends Build {

	public MvnBuild(int buildNumber, Date buildDate, ReqNewActivity request) {
		super(buildNumber, buildDate, request);
	}

	public MvnBuild(Build build) {
		this(build.getNumber(), build.getDate(), build.getRequest());
	}

	@Override
	public String toString() {
		return "MvnBuild [toString()=" + super.toString() + "]";
	}
}
