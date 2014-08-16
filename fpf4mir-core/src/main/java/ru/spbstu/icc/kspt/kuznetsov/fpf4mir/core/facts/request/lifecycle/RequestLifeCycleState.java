package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.lifecycle;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.RequestRelatedFactBase;

public class RequestLifeCycleState extends RequestRelatedFactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4335065479660383290L;

	public RequestLifeCycleState() {
		super();
	}

	public RequestLifeCycleState(Request request) {
		super(request);
	}
	
}
