package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestRelatedFact;

public class RequestRelatedFactBase implements RequestRelatedFact, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private RequestFact request;

	public RequestRelatedFactBase(RequestFact request) {
		this.request = request;
	}

	public RequestRelatedFactBase() {
		super();
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}
	
	public void reset(RequestFact request){
		this.request = request;
	}

	public void reset(RequestRelatedFactBase other){
		this.request = other.request;
	}
}
