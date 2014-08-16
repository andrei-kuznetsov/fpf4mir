package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.impl;

import java.io.File;
import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public abstract class ExecCommandBase extends ActivityRelatedFactBase implements ExecCommand, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2021345598551212750L;
	private String command;
	private File workingDir;

	public ExecCommandBase(Activity activity, String command, File workingDir) {
		super(activity);
		this.command = command;
		this.workingDir = workingDir;
	}

	public ExecCommandBase(Activity activity, String command) {
		this(activity, command, null);
	}
	
	public ExecCommandBase() {
		this(null, null, null);
	}

	public String getCommand() {
		return command;
	}

	public void setCommand(String command) {
		this.command = command;
	}

	public File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		this.workingDir = workingDir;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [command=" + command + ", args=" + getArgsList() +
				", workingDir="	+ workingDir + ", activity=" + getActivity().toShortString() + "]";
	}

}
