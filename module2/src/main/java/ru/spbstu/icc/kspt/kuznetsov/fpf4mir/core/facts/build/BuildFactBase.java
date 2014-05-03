package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;

public class BuildFactBase {
	private Build build;

	public BuildFactBase(Build build) {
		this.build = build;
	}

	public Build getBuild() {
		return build;
	}

	public Activity getActivity(){
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
		if (!(obj instanceof BuildFactBase))
			return false;
		BuildFactBase other = (BuildFactBase) obj;
		if (build == null) {
			if (other.build != null)
				return false;
		} else if (!build.equals(other.build))
			return false;
		return true;
	}
	
}
