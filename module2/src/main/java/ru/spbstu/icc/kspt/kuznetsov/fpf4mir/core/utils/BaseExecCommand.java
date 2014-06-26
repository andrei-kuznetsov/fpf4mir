package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.File;
import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecCommand;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;

public abstract class BaseExecCommand extends ActivityRelatedFactBase implements ExecCommand, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2021345598551212750L;
	private String command;
	private File workingDir;

	public BaseExecCommand(Activity activity, String command, File workingDir) {
		super(activity);
		this.command = command;
		this.workingDir = workingDir;
	}

	public BaseExecCommand(Activity activity, String command) {
		this(activity, command, null);
	}
	
	public BaseExecCommand() {
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
