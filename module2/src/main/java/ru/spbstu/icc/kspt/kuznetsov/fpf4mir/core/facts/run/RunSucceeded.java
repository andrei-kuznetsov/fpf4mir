package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class RunSucceeded extends RunFactBase implements ActivitySucceded{

	public RunSucceeded(Run run) {
		super(run);
	}

	@Override
	public String toString() {
		return "RunSucceeded [getRun()=" + getRun() + "]";
	}

}
