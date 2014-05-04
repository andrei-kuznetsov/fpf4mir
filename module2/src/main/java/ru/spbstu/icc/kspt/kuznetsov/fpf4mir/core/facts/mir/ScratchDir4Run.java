package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class ScratchDir4Run {
	private ScratchDir scratcDir;
	private RunActivity run;
	
	public ScratchDir4Run(RunActivity run, ScratchDir scratcDir) {
		this.scratcDir = scratcDir;
		this.run = run;
	}
	
	public ScratchDir getScratchDir() {
		return scratcDir;
	}
	
	public void setScratchDir(ScratchDir scratcDir) {
		this.scratcDir = scratcDir;
	}
	
	public RunActivity getRun() {
		return run;
	}
	
	public void setRun(RunActivity run) {
		this.run = run;
	}
	
}
