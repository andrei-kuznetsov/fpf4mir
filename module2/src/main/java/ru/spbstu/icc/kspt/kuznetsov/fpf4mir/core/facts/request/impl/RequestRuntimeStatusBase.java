package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRuntimeStatus;

public class RequestRuntimeStatusBase extends RequestStatusBase implements RequestRuntimeStatus {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1659774318252795269L;

	protected RequestRuntimeStatusBase() {
		super();
	}

	protected RequestRuntimeStatusBase(Request request, String statusString) {
		super(request, statusString);
	}

	protected RequestRuntimeStatusBase(Request request) {
		super(request);
	}

}
