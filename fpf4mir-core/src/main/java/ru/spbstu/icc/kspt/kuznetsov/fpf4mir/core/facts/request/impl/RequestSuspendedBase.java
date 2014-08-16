package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSuspended;

public class RequestSuspendedBase extends RequestRuntimeStatusBase implements RequestSuspended{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6392107710151570176L;

	protected RequestSuspendedBase() {
		super();
	}

	protected RequestSuspendedBase(Request request, String statusString) {
		super(request, statusString);
	}

	protected RequestSuspendedBase(Request request) {
		super(request);
	}

}
