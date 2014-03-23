package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityErrorFixed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class RunErrorFixed extends ActivityErrorFixed {

	public RunErrorFixed(RunError error) {
		super(error.getRun(), error);
	}

	public Run getRun(){
		return (Run) getActivity();
	}

	public void setRun(Run run){
		setActivity(run);
	}

	public RunError getRunError(){
		return (RunError) super.getError();
	}
	
	public void setRunError(RunError error) {
		super.setError(error);
	}
	
	@Override
	public String toString() {
		return "RunErrorFixed [getRun()=" + getRun() + ", getRunError()="
				+ getRunError() + "]";
	}
	
	@Override
	public int hashCode() {
		return super.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof RunErrorFixed) && super.equals(obj);
	}
}
