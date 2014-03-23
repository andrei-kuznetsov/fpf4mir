package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class JavaRunOption_VerboseCL extends OrdinalArgument implements JavaRunArgument{
	private static final String KEY = "-verbose:class";
	
	public JavaRunOption_VerboseCL() {
		super(null, KEY);
	}

	@Override
	public String toString() {
		return "JavaRunOption_VerboseCL [toString()=" + super.toString() + "]";
	}

}
