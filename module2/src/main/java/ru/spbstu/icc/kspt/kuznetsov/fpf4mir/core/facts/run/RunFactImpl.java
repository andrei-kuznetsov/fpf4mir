package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class RunFactImpl implements RunFact{
	private Run run;

	public RunFactImpl(Run build) {
		this.run = build;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "RunFactImpl [run=" + run + ", getClass()=" + getClass() + "]";
	}
}
