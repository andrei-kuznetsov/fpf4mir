package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class TestRunVerification_FileFormatOk extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5197600394069047575L;

	public TestRunVerification_FileFormatOk(Activity run) {
		super(run);
	}

	@Override
	public String toString() {
		return "TestRunVerification_FileFormatOk [getRun()=" + getActivity() + "]";
	}
}
