package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class TestRunVerificationSucceeded extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1521707920330659626L;

	public TestRunVerificationSucceeded(Activity run) {
		super(run);
	}
	

	@Override
	public String toString() {
		return "TestRunVerificationSucceeded [getRun()=" + getActivity() + "]";
	}
}
