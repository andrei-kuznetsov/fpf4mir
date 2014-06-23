package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFinalStatus;

public class RequestFailed extends RequestFinalStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2903747205898652066L;

	public RequestFailed() {
		super();
	}

	public RequestFailed(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestFailed(RequestFact request) {
		super(request);
	}

}
