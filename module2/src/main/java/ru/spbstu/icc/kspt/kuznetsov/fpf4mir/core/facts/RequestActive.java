package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.RequestRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class RequestActive extends RequestRelatedFactBase{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1884825272624319267L;

	public RequestActive() {
		super();
	}

	public RequestActive(RequestFact request) {
		super(request);
	}

}
