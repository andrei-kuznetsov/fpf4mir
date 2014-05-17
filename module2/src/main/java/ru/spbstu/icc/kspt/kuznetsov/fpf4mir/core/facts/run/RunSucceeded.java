package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class RunSucceeded extends RunFactBase implements ActivitySucceeded{

	public RunSucceeded(RunActivity run) {
		super(run);
	}

	@Override
	public String toString() {
		return "RunSucceeded [getRun()=" + getRun() + "]";
	}

}
