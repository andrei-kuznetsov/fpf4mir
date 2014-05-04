package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class RunSucceeded extends RunFactBase implements ActivitySucceded{

	public RunSucceeded(RunActivity run) {
		super(run);
	}

	@Override
	public String toString() {
		return "RunSucceeded [getRun()=" + getRun() + "]";
	}

}
