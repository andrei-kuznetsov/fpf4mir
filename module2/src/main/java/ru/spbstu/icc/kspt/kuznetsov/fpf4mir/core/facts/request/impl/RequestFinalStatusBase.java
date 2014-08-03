package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFinalStatus;

public class RequestFinalStatusBase extends RequestStatusBase implements RequestFinalStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5857124098913997391L;

	protected RequestFinalStatusBase() {
		super();
	}

	protected RequestFinalStatusBase(RequestFact request, String statusString) {
		super(request, statusString);
	}

	protected RequestFinalStatusBase(RequestFact request) {
		super(request);
	}

}
