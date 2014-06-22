package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class TestRunVerification_FileNamesOk extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2458291142235170458L;

	public TestRunVerification_FileNamesOk(Activity run) {
		super(run);
	}
	

	@Override
	public String toString() {
		return "TestRunVerification_FileNamesOk [getRun()=" + getActivity() + "]";
	}
}
