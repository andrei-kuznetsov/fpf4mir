package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;

public class RequestSucceededBase extends RequestFinalStatusBase implements RequestSucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = 620098420632441812L;

	protected RequestSucceededBase() {
		super();
	}

	protected RequestSucceededBase(Request request, String statusString) {
		super(request, statusString);
	}

	protected RequestSucceededBase(Request request) {
		super(request);
	}

}
