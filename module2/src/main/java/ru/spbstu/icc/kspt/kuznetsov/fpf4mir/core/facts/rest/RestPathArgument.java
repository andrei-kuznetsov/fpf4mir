package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.impl.RequestRelatedFactBase;


public class RestPathArgument extends RequestRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -176231347322282308L;
	private int order;
	private String value;
	
	public RestPathArgument() {
	}
	
	public RestPathArgument(ReqRestCommand restCmd, int order, String value) {
		super(restCmd);
		this.order = order;
		this.value = value;
	}

	public int getOrder() {
		return order;
	}
	public void setOrder(int order) {
		this.order = order;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [order=" + order + ", value=" + value
				+ ", restCmd" + getRequest() + "]";
	}
	
}
