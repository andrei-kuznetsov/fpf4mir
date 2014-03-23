package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actions;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Test;

public class ZipUnzipTest {

	@Test
	public void testUnzipFileStringString() throws URISyntaxException {
		URL url = ZipUnzipTest.class.getClassLoader().getResource("c1.zip");
		File f = new File(url.toURI());
		String base = f.getParent();
		File target = new File(base + "/target");
		
		if (target.exists()){
			target.delete();
		}
		
		ZipUnzip.unzip(f, target.getAbsolutePath());
		assertTrue(new File(base + "/target/f_1").isDirectory());
		assertTrue(new File(base + "/target/d_1").isFile());
		
		assertTrue(new File(base + "/target/f_1/f_1_1").isDirectory());
		assertTrue(new File(base + "/target/f_1/f_1_2").isDirectory());
		assertTrue(new File(base + "/target/f_1/d_1_1").isFile());
		
		assertTrue(new File(base + "/target/f_1/f_1_1/d_1_1_1").isFile());
		assertTrue(new File(base + "/target/f_1/f_1_1/d_1_1_2").isFile());
		assertTrue(new File(base + "/target/f_1/f_1_2/d_1_2_1").isFile());
	}

}
