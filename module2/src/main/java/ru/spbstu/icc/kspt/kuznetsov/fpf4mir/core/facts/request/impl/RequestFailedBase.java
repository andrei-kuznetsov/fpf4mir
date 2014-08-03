package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFailed;

public class RequestFailedBase extends RequestFinalStatusBase implements RequestFailed {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2903747205898652066L;

	protected RequestFailedBase() {
		super();
	}

	protected RequestFailedBase(RequestFact request, String statusString) {
		super(request, statusString);
	}

	protected RequestFailedBase(RequestFact request) {
		super(request);
	}

}
