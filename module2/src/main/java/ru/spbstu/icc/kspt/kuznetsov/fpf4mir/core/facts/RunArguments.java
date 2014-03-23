package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Arrays;
import java.util.LinkedList;

public class RunArguments extends LinkedList<String>{
	private static final long serialVersionUID = 1L;

	public RunArguments (String ... args) {
		super();
		this.addAll(Arrays.asList(args));
	}
}
