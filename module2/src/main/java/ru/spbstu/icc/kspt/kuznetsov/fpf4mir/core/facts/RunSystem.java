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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((runSystem == null) ? 0 : runSystem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RunSystem))
			return false;
		RunSystem other = (RunSystem) obj;
		if (runSystem != other.runSystem)
			return false;
		return true;
	}
}
