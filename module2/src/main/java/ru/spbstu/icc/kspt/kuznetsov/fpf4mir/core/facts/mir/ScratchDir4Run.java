package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class ScratchDir4Run {
	private ScratchDir scratcDir;
	private Run run;
	
	public ScratchDir4Run(Run run, ScratchDir scratcDir) {
		this.scratcDir = scratcDir;
		this.run = run;
	}
	
	public ScratchDir getScratchDir() {
		return scratcDir;
	}
	
	public void setScratchDir(ScratchDir scratcDir) {
		this.scratcDir = scratcDir;
	}
	
	public Run getRun() {
		return run;
	}
	
	public void setRun(Run run) {
		this.run = run;
	}
	
}
