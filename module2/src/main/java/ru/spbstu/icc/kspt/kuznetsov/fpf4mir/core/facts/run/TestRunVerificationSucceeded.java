package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class TestRunVerificationSucceeded extends TestRunFact {
	public TestRunVerificationSucceeded(Run run) {
		super(run);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof TestRunVerificationSucceeded) && super.equals(obj);
	}

	@Override
	public String toString() {
		return "TestRunVerificationSucceeded [getRun()=" + getRun() + "]";
	}
}
