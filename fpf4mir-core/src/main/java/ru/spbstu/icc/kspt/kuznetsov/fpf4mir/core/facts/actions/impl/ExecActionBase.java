package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ExecAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public class ExecActionBase extends ActionFactBase implements ExecAction  {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625795389816472639L;
	private ExecCommand execCommand;

	protected ExecActionBase(ExecCommand command) {
		super(command.getActivity());
		this.execCommand = command;
	}
	
	public String getCommand() {
		return execCommand.getCommand();
	}

	public File getWorkingDir() {
		return execCommand.getWorkingDir();
	}

	public List<String> getArguments() {
		return execCommand.getArgsList();
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [execCommand=" + execCommand
				+ ", activity=" + getActivity() + "]";
	}

	public ExecCommand getExecCommand() {
		return execCommand;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.execCommand = execCommand;
	}
}
