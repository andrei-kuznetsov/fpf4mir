package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core;

import static org.junit.Assert.*;

import java.io.File;
import java.net.URISyntaxException;

import org.junit.Test;

import utils.PathUtils;

public class MainTest {

	@Test
	public void testMain_InvalidOriginalArtifact() throws URISyntaxException, Exception {
		try {
			Main.main(new String[]{"/invalid/file/name", PathUtils.getTestResourceDir("/c2").getAbsolutePath()});
			fail("Must throw exeption for invalid 'original artifact' path");
		} catch (RuntimeException t){
			assertEquals("Original artifact: file '/invalid/file/name' doesn't exist!", t.getMessage());
		}
	}

	@Test
	public void testMain_InvalidDataset() throws URISyntaxException, Exception {
		File dataset = new File(PathUtils.getTestResourceDir("/c2"), "invalid");
		try {
			Main.main(new String[]{PathUtils.getTestResourceFile("/c2/file").getAbsolutePath(), dataset.getAbsolutePath()});
			fail("Must throw exeption for invalid 'dataset' path");
		} catch (RuntimeException t){
			assertEquals("Folder '" + dataset.getAbsolutePath() + "' does not exist!", t.getMessage());
		}
	}
}
