package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.RequestRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public class RequestStatus extends RequestRelatedFactBase implements RequestRelatedFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7272163469535280982L;
	private String message = "No status available.";
	
	public RequestStatus() {
		super();
	}

	public RequestStatus(RequestFact request) {
		super(request);
	}

	protected RequestStatus(RequestFact request, String statusString) {
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
