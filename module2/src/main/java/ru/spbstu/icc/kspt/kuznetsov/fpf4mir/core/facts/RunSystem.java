package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class RunSystem {
	public enum RUN_SYSTEMS {
		JAVA,
		PYTHON
	}
	
	private RUN_SYSTEMS runSystem;

	public RunSystem(RUN_SYSTEMS runSystem) {
		this.runSystem = runSystem;
	}

	public RUN_SYSTEMS getRunSystem() {
		return runSystem;
	}

	public void setRunSystem(RUN_SYSTEMS runSystem) {
		this.runSystem = runSystem;
	}

	@Override
	public String toString() {
		return "RunSystem [runSystem=" + runSystem + "]";
	}
}
