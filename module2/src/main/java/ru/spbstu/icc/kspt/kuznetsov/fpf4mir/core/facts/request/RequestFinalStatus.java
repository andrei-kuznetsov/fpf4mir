package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public class RequestFinalStatus extends RequestStatus implements RequestRelatedFact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3553603351960909498L;

	public RequestFinalStatus() {
		super();
	}

	public RequestFinalStatus(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestFinalStatus(RequestFact request) {
		super(request);
	}
	
}
