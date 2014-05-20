package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestSucceeded extends RequestStatus {

	public RequestSucceeded(RequestFact request, String statusString) {
		super(request, statusString);
	}

	public RequestSucceeded(RequestFact request) {
		this(request, "<no additional information available");
	}
}
