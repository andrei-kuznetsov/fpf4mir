package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestSucceeded;

public class GenericRequestSucceeded extends RequestSucceededBase implements RequestSucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = 305607218859870076L;

	public GenericRequestSucceeded() {
		super();
	}

	public GenericRequestSucceeded(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public GenericRequestSucceeded(RequestFact request) {
		super(request);
	}

}
