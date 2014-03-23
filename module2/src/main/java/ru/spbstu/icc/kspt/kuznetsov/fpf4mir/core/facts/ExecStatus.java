package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExecStatus {
	private Activity activity;
	private ExecCommand execCommand;
	private int status;
	private File fileOut;
	private File fileErr;
	

	public ExecStatus(Activity activity, ExecCommand execCommand, int status, File fileOut, File fileErr) {
		this.activity = activity;
		this.execCommand = execCommand;
		this.status = status;
		this.fileOut = fileOut;
		this.fileErr = fileErr;
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
		return "ExecStatus [activity=" + activity + ", execCommand="
				+ execCommand + ", status=" + status + ", fileOut=" + fileOut
				+ ", fileErr=" + fileErr + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result
				+ ((execCommand == null) ? 0 : execCommand.hashCode());
		result = prime * result + ((fileErr == null) ? 0 : fileErr.hashCode());
		result = prime * result + ((fileOut == null) ? 0 : fileOut.hashCode());
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ExecStatus))
			return false;
		ExecStatus other = (ExecStatus) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (execCommand == null) {
			if (other.execCommand != null)
				return false;
		} else if (!execCommand.equals(other.execCommand))
			return false;
		if (fileErr == null) {
			if (other.fileErr != null)
				return false;
		} else if (!fileErr.equals(other.fileErr))
			return false;
		if (fileOut == null) {
			if (other.fileOut != null)
				return false;
		} else if (!fileOut.equals(other.fileOut))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public ExecCommand getExecCommand() {
		return execCommand;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.execCommand = execCommand;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}
}
