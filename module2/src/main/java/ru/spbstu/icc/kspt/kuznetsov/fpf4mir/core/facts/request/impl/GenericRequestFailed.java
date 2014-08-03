package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFailed;

public class GenericRequestFailed extends RequestFailedBase implements RequestFailed{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2126016277141706999L;

	public GenericRequestFailed() {
		super();
	}

	public GenericRequestFailed(Request request, String statusString) {
		super(request, statusString);
	}

	public GenericRequestFailed(Request request) {
		super(request);
	}

}
