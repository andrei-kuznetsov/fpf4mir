package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;


public class TestRunVerification_FileNamesOkTest {

	@Test
	public void test() {
		Activity run = null; // TODO: (RunActivity) new RunActivity().reset(R.id.TestActivity, new Date(), null);
		TestRunVerification_FileFormatOk fmt = new TestRunVerification_FileFormatOk(run);
		TestRunVerification_FileNamesOk fn = new TestRunVerification_FileNamesOk(run);
		
		assertFalse(fmt.equals(fn));
	}

}
