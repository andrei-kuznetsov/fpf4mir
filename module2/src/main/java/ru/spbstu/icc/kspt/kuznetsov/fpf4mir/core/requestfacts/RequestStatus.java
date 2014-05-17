package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestStatus {
	private RequestFact request;
	private String statusString = "No status available.";
	private boolean succeeded;
	
	public RequestStatus(RequestFact request, String statusString, boolean succeeded) {
		super();
		this.request = request;
		this.statusString = statusString;
		this.succeeded = succeeded;
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

	public boolean isSucceeded() {
		return succeeded;
	}

	public void setSucceeded(boolean succeeded) {
		this.succeeded = succeeded;
	}

	@Override
	public String toString() {
		return "RequestStatus [request=" + request + ", statusString="
				+ statusString + ", succeeded=" + succeeded + "]";
	}
}
