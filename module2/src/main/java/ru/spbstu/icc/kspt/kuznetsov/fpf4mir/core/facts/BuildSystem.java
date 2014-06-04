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
	public String toString() {
		return "BuildSystem [buildSystem=" + buildSystem + "]";
	}
	
}
