package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.java;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class JavaRun extends Run {

	public JavaRun(Run run){
		super(run);
	}
	public JavaRun(int number, Date date, ReqNewActivity request) {
		super(null, number, date, request);
	}
	
	@Override
	public String toString() {
		return "JavaRun [toString()=" + super.toString() + "]";
	}

}
