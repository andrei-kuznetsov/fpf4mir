package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class JavaRunOption_Headless extends OrdinalArgument implements JavaRunArgument{
	private static final String KEY = "-Djava.awt.headless=true";
	
	public JavaRunOption_Headless() {
		super(null, KEY);
	}

	@Override
	public String toString() {
		return "JavaRunOption_Headless [toString()=" + super.toString() + "]";
	}

}
