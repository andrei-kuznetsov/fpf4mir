package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public final class GenericExecAction extends ExecActionBase implements ExecAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4102957755745893715L;

	public GenericExecAction(ExecCommand command) {
		super(command);
	}

}
