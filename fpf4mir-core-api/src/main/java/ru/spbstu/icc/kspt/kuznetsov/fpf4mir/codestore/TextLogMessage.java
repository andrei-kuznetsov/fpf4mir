package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore;

import java.io.Serializable;

public class TextLogMessage extends LogMessageBase implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6920404821460321449L;
	
	private String message;
	
	
	public TextLogMessage(String submissionId, int runId, String message) {
		super(submissionId, runId);
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return String.format("TextLogMessage: [/%s/%d] '%s'" , submissionId, runId, message);
	}
}
