package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.Request;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestRelatedFact;

public class RequestRelatedFactBase implements RequestRelatedFact, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Request request;

	public RequestRelatedFactBase(Request request) {
		this.request = request;
	}

	public RequestRelatedFactBase() {
		super();
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) {
		this.request = request;
	}
	
	public void reset(Request request){
		this.request = request;
	}

	public void reset(RequestRelatedFactBase other){
		this.request = other.request;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [request=" + request + "]";
	}
	
}
