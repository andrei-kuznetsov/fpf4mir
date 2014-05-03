package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestStatus {
	private RequestFact request;
	private String statusString = "No status available.";

	public RequestStatus(RequestFact request, String statusString) {
		super();
		this.request = request;
		this.statusString = statusString;
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}

	public String getStatusString() {
		return statusString;
	}

	public void setStatusString(String statusString) {
		this.statusString = statusString;
	}
	
}
