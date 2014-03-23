package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;

public class BuildFact {
	private Build build;

	public BuildFact(Build build) {
		this.build = build;
	}

	public Build getBuild() {
		return build;
	}

	public void setBuild(Build build) {
		this.build = build;
	}

	@Override
	public String toString() {
		return "BuildFact [build=" + build + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((build == null) ? 0 : build.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BuildFact))
			return false;
		BuildFact other = (BuildFact) obj;
		if (build == null) {
			if (other.build != null)
				return false;
		} else if (!build.equals(other.build))
			return false;
		return true;
	}
	
}
