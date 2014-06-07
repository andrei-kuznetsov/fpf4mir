package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.File;
import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecCommand;

public abstract class BaseExecCommand implements ExecCommand, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2021345598551212750L;
	private String command;
	private File workingDir;
	private Activity activity;

	public BaseExecCommand(Activity activity, String command, File workingDir) {
		this.command = command;
		this.workingDir = workingDir;
		this.activity = activity;
	}

	public BaseExecCommand(Activity activity, String command) {
		this(activity, command, null);
	}
	
	public BaseExecCommand() {
		this(null, null, null);
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
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
		return getClass().getSimpleName() + " [command=" + command + ", workingDir="
				+ workingDir + ", activity=" + activity + ", args=" + getArgsList() + "]";
	}

}
