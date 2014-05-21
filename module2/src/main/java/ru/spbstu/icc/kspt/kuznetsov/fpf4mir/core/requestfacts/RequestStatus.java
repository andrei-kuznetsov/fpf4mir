package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestStatus {
	private RequestFact request;
	private String message = "No status available.";
	
	protected RequestStatus(RequestFact request, String statusString) {
		super();
		this.request = request;
		this.message = statusString;
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}

	

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [request=" + request + ", statusString="
				+ message + "]";
	}
}
