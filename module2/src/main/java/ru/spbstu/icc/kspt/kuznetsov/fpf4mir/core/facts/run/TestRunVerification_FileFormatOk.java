package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class TestRunVerification_FileFormatOk extends TestRunFact {
	public TestRunVerification_FileFormatOk(Run run) {
		super(run);
	}

	@Override
	public boolean equals(Object obj) {
		return obj != null && obj instanceof TestRunVerification_FileFormatOk && super.equals(obj);
	}

	@Override
	public String toString() {
		return "TestRunVerification_FileFormatOk [getRun()=" + getRun() + "]";
	}
}
