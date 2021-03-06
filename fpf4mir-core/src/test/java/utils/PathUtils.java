package utils;

import java.io.File;
import java.net.URISyntaxException;
import java.net.URL;

import org.junit.Assert;

public class PathUtils {
	public static File getTestResource(String child) throws URISyntaxException{
        URL url = PathUtils.class.getClassLoader().getResource("c1.zip");
		File f = new File(url.toURI());
		f = new File(f.getParent() + child);
		return f;
	}

	public static File getTestResourceDir(String child) throws URISyntaxException{
		File f = getTestResource(child);
		Assert.assertTrue(f.isDirectory());
		return f;
	}

	public static File getTestResourceFile(String child) throws URISyntaxException{
		File f = getTestResource(child);
		Assert.assertTrue(f.isFile());
		return f;
	}
}
