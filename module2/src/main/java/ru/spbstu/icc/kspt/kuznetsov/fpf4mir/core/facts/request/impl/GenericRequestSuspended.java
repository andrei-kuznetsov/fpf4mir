package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSuspended;

public final class GenericRequestSuspended extends RequestSuspendedBase implements RequestSuspended {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1178024485886341121L;

	public GenericRequestSuspended() {
		super();
	}

	public GenericRequestSuspended(Request request, String statusString) {
		super(request, statusString);
	}

	public GenericRequestSuspended(Request request) {
		super(request);
	}

}
