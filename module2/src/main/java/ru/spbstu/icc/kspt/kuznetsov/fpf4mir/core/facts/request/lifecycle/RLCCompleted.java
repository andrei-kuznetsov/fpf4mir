package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.lifecycle;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;

public class RLCCompleted extends RequestLifeCycleState {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2933982878532428071L;

	public RLCCompleted() {
		super();
	}

	public RLCCompleted(RequestFact request) {
		super(request);
	}

}
