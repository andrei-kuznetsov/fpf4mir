package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class TestRunError extends RunError{

	protected TestRunError(RunErrorIds errorId, Run run, String message) {
		super(errorId, run, message);
	}

}
