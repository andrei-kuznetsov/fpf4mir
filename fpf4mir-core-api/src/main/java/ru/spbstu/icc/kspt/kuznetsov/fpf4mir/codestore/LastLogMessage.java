package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.codestore;

import java.io.Serializable;

public class LastLogMessage extends LogMessageBase implements Serializable {

	public LastLogMessage(String submissionId, int runId) {
		super(submissionId, runId);
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -2072847523106893235L;


}
