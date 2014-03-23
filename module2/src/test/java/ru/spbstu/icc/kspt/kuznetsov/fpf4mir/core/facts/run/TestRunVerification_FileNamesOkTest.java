package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import static org.junit.Assert.assertFalse;

import java.util.Date;

import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;


public class TestRunVerification_FileNamesOkTest {

	@Test
	public void test() {
		Run run = new Run(R.id.TestActivity, 0, new Date(), null);
		TestRunVerification_FileFormatOk fmt = new TestRunVerification_FileFormatOk(run);
		TestRunVerification_FileNamesOk fn = new TestRunVerification_FileNamesOk(run);
		
		assertFalse(fmt.equals(fn));
	}

}
