package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class RestArgument extends ActivityRelatedFactBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = -176231347322282308L;
	private int order;
	private String value;
	
	public RestArgument() {
	}
	
	public RestArgument(Activity activity, int order, String value) {
		super(activity);
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
				+ ", getActivity()=" + getActivity() + "]";
	}
}
