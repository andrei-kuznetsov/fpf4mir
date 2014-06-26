package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest;


public class RestFormArgument extends RestRequestRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1696510994876126790L;
	
	private String name;
	private String value;
	
	public RestFormArgument() {
	}
	
	public RestFormArgument(RestRequestCommand restCmd, String name, String value) {
		super(restCmd);
		this.name = name;
		this.value = value;
	}

	public String getName() {
		return name;
	}
	public void setString(String name) {
		this.name = name;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", value=" + value
				+ ", restCmd" + getRestCmd() + "]";
	}
}
