package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public class ExecStatusBase extends ActionStatusBase implements ExecStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5739288970292691981L;
	private ExecCommand execCommand;
	private int status;
	private File fileOut;
	private File fileErr;
	

	protected ExecStatusBase(Activity activity, ExecCommand execCommand, int status, File fileOut, File fileErr) {
		super(activity);
		this.execCommand = execCommand;
		this.status = status;
		this.fileOut = fileOut;
		this.fileErr = fileErr;
	}

	public FileArtifact getFileOut(){
		return new GenericFileArtifact(getActivity(), fileOut.getParent(), fileOut.getName());
	}

	public FileArtifact getFileErr(){
		return new GenericFileArtifact(getActivity(), fileErr.getParent(), fileErr.getName());
	}
	
	public boolean isSucceeded(){
		return status == 0;
	}
	
	public String getSingleLineFromOut(String pattern){
		return getSingleLineFromFile(pattern, fileOut);
	}

	public String getSingleLineFromErr(String pattern){
		return getSingleLineFromFile(pattern, fileErr);
	}

	public String getSingleLine(String pattern){
		String res = getSingleLineFromOut(pattern);
		if (res == null){
			res = getSingleLineFromErr(pattern);
		}
		
		return res;
	}
	
	public boolean containsString(String pattern){
		return getSingleLine(pattern) != null;
	}
	
	private String getSingleLineFromFile(String pattern, File f) {
		Pattern regexp = Pattern.compile(pattern);
		Matcher matcher = regexp.matcher("");
		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(f));
			String line = null;
			while ((line = reader.readLine()) != null) {
				matcher.reset(line); // reset the input
				if (matcher.find()) {
					return line;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (reader != null)
					reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return null;
	}

	final static Charset ENCODING = StandardCharsets.UTF_8;

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [activity=" + getActivity() + ", execCommand="
				+ execCommand + ", status=" + status + ", fileOut=" + fileOut
				+ ", fileErr=" + fileErr + "]";
	}

	public ExecCommand getExecCommand() {
		return execCommand;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.execCommand = execCommand;
	}
}
