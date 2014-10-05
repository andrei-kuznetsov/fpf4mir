package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public class ExecActionBase extends ActionFactBase<ExecCommand> implements ExecAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625795389816472639L;

	protected ExecActionBase(ExecCommand command) {
		super(command.getActivity());
		this.parameter = command;
	}
	
	public String getCommand() {
		return parameter.getCommand();
	}

	public File getWorkingDir() {
		return parameter.getWorkingDir();
	}

	public List<String> getArguments() {
		return parameter.getArgsList();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [execCommand=" + parameter
				+ ", activity=" + getActivity() + "]";
	}

	public ExecCommand getExecCommand() {
		return parameter;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.parameter = execCommand;
	}
}
