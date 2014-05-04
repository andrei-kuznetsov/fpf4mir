package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class RunFactBase {
	private RunActivity run;

	public RunFactBase(RunActivity build) {
		this.run = build;
	}

	public RunActivity getRun() {
		return run;
	}
	
	public Activity getActivity(){
		return run;
	}

	public void setRun(RunActivity run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "RunFactImpl [run=" + run + ", getClass()=" + getClass() + "]";
	}
}
