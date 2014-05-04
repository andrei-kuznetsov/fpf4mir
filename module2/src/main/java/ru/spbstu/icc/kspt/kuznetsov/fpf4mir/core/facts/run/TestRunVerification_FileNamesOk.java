package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class TestRunVerification_FileNamesOk extends TestRunFact {
	public TestRunVerification_FileNamesOk(RunActivity run) {
		super(run);
	}
	
	@Override
	public boolean equals(Object obj) {
		return (obj instanceof TestRunVerification_FileNamesOk) && super.equals(obj);
	}

	@Override
	public String toString() {
		return "TestRunVerification_FileNamesOk [getRun()=" + getRun() + "]";
	}
}
