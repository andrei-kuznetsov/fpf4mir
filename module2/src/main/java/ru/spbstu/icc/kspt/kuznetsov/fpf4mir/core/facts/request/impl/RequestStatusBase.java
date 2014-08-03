package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;

public class RequestStatusBase extends RequestRelatedFactBase implements RequestStatus {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272163469535280982L;
	private String message = "No status available.";
	
	protected RequestStatusBase() {
		super();
	}

	protected RequestStatusBase(RequestFact request) {
		super(request);
	}

	protected RequestStatusBase(RequestFact request, String statusString) {
		super(request);
		this.message = statusString;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [request=" + getRequest() + ", statusString="
				+ message + "]";
	}
	
	public RequestStatus reset(RequestFact request, String message){
		super.reset(request);
		this.message = message;
		return this;
	}
}
