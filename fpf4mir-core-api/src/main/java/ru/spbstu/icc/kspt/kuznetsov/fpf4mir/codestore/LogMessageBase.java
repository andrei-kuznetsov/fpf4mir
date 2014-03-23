package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore;

import java.io.Serializable;


public class LogMessageBase implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5054415247540124221L;
	
	protected String submissionId;
	protected int runId;
	
	public LogMessageBase(String submissionId, int runId) {
		super();
		this.submissionId = submissionId;
		this.runId = runId;
	}

	public String getSubmissionId() {
		return submissionId;
	}

	public void setSubmissionId(String submissionId) {
		this.submissionId = submissionId;
	}

	public int getRunId() {
		return runId;
	}

	public void setRunId(int runId) {
		this.runId = runId;
	}

}