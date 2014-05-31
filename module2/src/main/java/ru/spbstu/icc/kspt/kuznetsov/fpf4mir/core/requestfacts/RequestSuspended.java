package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestSuspended extends RequestStatus {

	public RequestSuspended(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestSuspended(RequestFact request) {
		this(request, "<no additional information available");
	}
}
