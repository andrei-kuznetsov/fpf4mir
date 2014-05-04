package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityErrorFixed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;

public class BuildErrorFixed extends ActivityErrorFixed {
	
	public BuildErrorFixed(BuildError buildError) {
		super(buildError);
	}

	public BuildError getBuildError() {
		return (BuildError) super.getError();
	}

	public void setBuildError(BuildError buildError) {
		super.setError(buildError);
	}

	public BuildActivity getBuild() {
		return (BuildActivity) super.getActivity();
	}
	
	@Override
	public String toString() {
		return "BuildErrorFixed [buildError=" + getBuildError() + ", getBuild()="
				+ getBuild() + "]";
	}

	@Override
	public int hashCode() {
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof BuildErrorFixed) && super.equals(obj);
	}

}
