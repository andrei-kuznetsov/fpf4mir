package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.lifecycle;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.RequestRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class RequestLifeCycleState extends RequestRelatedFactBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4335065479660383290L;

	public RequestLifeCycleState() {
		super();
	}

	public RequestLifeCycleState(RequestFact request) {
		super(request);
	}
	
}
