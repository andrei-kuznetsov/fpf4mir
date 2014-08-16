package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;
import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.TextFileArtifact;

public class TextFileArtifactBase extends FileArtifactBase implements TextFileArtifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 4881251053400151702L;
	private static final Logger log = Logger.getLogger(TextFileArtifact.class);
	
	protected TextFileArtifactBase() {
		super();
	}

	public boolean lineFormatPattern(String pattern){
		Pattern regexp = Pattern.compile(pattern);
		Matcher matcher = regexp.matcher("");
		BufferedReader reader = null;

		boolean ret = true;
		
		try {
			reader = new BufferedReader(new FileReader(_getFile()));
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
