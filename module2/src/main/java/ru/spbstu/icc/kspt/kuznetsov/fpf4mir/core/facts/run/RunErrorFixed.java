package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityErrorFixed;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class RunErrorFixed extends ActivityErrorFixed {

	public RunErrorFixed(RunError error) {
		super(error);
	}

	public RunActivity getRun(){
		return (RunActivity) getActivity();
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
