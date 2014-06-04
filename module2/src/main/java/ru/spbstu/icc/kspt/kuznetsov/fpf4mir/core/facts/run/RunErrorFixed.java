package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityErrorFixed;

public class RunErrorFixed extends ActivityErrorFixed {

	public RunErrorFixed(RunError error) {
		super(error);
	}
	
	@Override
	public String toString() {
		return "RunErrorFixed [getRun()=" + getActivity() + ", getRunError()="
				+ getError() + "]";
	}
	
}
