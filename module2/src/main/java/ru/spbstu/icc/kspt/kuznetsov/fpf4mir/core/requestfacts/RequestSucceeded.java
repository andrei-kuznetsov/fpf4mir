package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFinalStatus;

public class RequestSucceeded extends RequestFinalStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4314923782037090934L;

	public RequestSucceeded() {
		super();
	}

	public RequestSucceeded(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestSucceeded(RequestFact request) {
		super(request);
	}

}
