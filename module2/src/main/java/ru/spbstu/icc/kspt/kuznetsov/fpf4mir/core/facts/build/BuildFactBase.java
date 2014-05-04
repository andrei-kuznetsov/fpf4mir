package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;

public class BuildFactBase {
	private BuildActivity build;

	public BuildFactBase(BuildActivity build) {
		this.build = build;
	}

	public BuildActivity getBuild() {
		return build;
	}

	public Activity getActivity(){
		return build;
	}
	
	public void setBuild(BuildActivity build) {
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
