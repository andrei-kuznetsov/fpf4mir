package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.RequestRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public class RequestStatus extends RequestRelatedFactBase implements RequestRelatedFact {
	private String message = "No status available.";
	
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
}
