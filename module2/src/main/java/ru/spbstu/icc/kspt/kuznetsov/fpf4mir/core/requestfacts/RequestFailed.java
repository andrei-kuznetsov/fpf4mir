package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestFailed extends RequestStatus {

	public RequestFailed(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestFailed(RequestFact request) {
		this(request, "<no additional information available");
	}
}
