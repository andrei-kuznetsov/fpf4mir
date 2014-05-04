package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class TestRunVerificationSucceeded extends TestRunFact {
	public TestRunVerificationSucceeded(RunActivity run) {
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
