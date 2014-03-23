package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class BuildSystem {
	public enum BUILD_SYSTEMS {
		MAVEN,
		ANT,
		MAKE,
		OTHER
	}
	
	private BUILD_SYSTEMS buildSystem = BUILD_SYSTEMS.OTHER;

	public BuildSystem(BUILD_SYSTEMS buildSystem) {
		super();
		this.buildSystem = buildSystem;
	}
	
	public BuildSystem() {
	}

	public BUILD_SYSTEMS getBuildSystem() {
		return buildSystem;
	}

	public void setBuildSystem(BUILD_SYSTEMS buildSystem) {
		this.buildSystem = buildSystem;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((buildSystem == null) ? 0 : buildSystem.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BuildSystem other = (BuildSystem) obj;
		if (buildSystem != other.buildSystem)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "BuildSystem [buildSystem=" + buildSystem + "]";
	}
	
}
