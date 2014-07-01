package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction;

public class UserActionBase extends ActionFactBase implements UserAction{
	/**
	 * 
	 */
	private static final long serialVersionUID = -888602607972521791L;
	private String description;

	protected UserActionBase() {
	}
	
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
