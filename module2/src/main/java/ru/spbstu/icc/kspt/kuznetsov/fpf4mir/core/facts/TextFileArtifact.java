package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.drools.RuntimeDroolsException;

public class TextFileArtifact extends FileArtifact {
	private static final Logger log = Logger.getLogger(TextFileArtifact.class);
	
	public TextFileArtifact() {
		super();
	}

	public TextFileArtifact(String id, File file) {
		super(id, file);
	}

	public TextFileArtifact(String id) {
		super(id);
	}

	public boolean lineFormatPattern(String pattern){
		Pattern regexp = Pattern.compile(pattern);
		Matcher matcher = regexp.matcher("");
		BufferedReader reader = null;

		boolean ret = true;
		
		try {
			reader = new BufferedReader(new FileReader(getFile()));
			String line = null;
			WHILE: while ((line = reader.readLine()) != null) {
				matcher.reset(line); // reset the input
				if (!matcher.find()) {
					ret = false;
					log.info("Comparison failure at line:" + line);
					System.out.println("Comparison failure at line:" + line);
					break WHILE;
				}
			}
		} catch (IOException e) {
			throw new RuntimeDroolsException("Can't match a line", e);
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return ret;
	}
}
