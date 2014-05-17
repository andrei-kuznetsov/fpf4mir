package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

public class RequestSubstatusBase implements RequestSubstatus {
	private RequestFact request;

	public RequestSubstatusBase(RequestFact request) {
		super();
		this.request = request;
	}

	@Override
	public RequestFact getRequest() {
		return request;
	}

	@Override
	public void setRequest(RequestFact request) {
		this.request = request;
	}

}
