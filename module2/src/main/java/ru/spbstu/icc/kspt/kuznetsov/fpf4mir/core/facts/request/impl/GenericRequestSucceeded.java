package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;

public class GenericRequestSucceeded extends RequestSucceededBase implements RequestSucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = 305607218859870076L;

	public GenericRequestSucceeded() {
		super();
	}

	public GenericRequestSucceeded(Request request, String statusString) {
		super(request, statusString);
	}

	public GenericRequestSucceeded(Request request) {
		super(request);
	}

}
