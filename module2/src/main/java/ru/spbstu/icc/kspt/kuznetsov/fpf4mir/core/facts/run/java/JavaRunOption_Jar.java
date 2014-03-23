package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;

public class JavaRunOption_Jar extends KeyValueArgument implements JavaRunArgument{
	private static final String KEY = "-jar";
	
	public JavaRunOption_Jar(File jar) {
		super(null, KEY, jar.getAbsolutePath());
	}

	@Override
	public String toString() {
		return "JavaRunOption_Jar [toString()=" + super.toString() + "]";
	}

}
