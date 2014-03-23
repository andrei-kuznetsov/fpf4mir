package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actions;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.log4j.Logger;
import org.junit.Test;

public class BuildActionTest {
	private static final Logger logger = Logger.getLogger(BuildActionTest.class);
	
	@Test
	public void cmdInvokationTest() throws IOException, InterruptedException{
		final String command = "ls";
        final Runtime r = Runtime.getRuntime();
        final Process p = r.exec(command, null, new File("."));
        final int returnCode = p.waitFor();

        final BufferedReader is = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while ((line = is.readLine()) != null) {
            logger.warn(line);
            System.out.println(line);
        }
        final BufferedReader is2 = new BufferedReader(new InputStreamReader(p.getErrorStream()));
        while ((line = is2.readLine()) != null) {
            logger.warn(line);
            System.err.println(line);
        }
	}
}
