package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class ScratchDir4Run extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -56582441620072387L;
	private ScratchDir scratcDir;
	
	public ScratchDir4Run(Activity run, ScratchDir scratcDir) {
		super(run);
		this.scratcDir = scratcDir;
	}
	
	public ScratchDir getScratchDir() {
		return scratcDir;
	}
	
	public void setScratchDir(ScratchDir scratcDir) {
		this.scratcDir = scratcDir;
	}
	
}
