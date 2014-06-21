package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class RestRequestRelatedFactBase implements FPFCloneable, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4173856006520669392L;
	private RestRequestCommand restCmd;
	
	public RestRequestRelatedFactBase() {
		super();
	}

	public RestRequestRelatedFactBase(RestRequestCommand restCmd) {
		super();
		this.restCmd = restCmd;
	}

	public RestRequestCommand getRestCmd() {
		return restCmd;
	}

	public void setRestCmd(RestRequestCommand restCmd) {
		this.restCmd = restCmd;
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [restCmd=" + restCmd + "]";
	}
	
}
