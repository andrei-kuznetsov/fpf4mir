package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecCommand;

public abstract class BaseExecCommand implements ExecCommand{
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
		return "BaseExecCommand [command=" + command + ", workingDir="
				+ workingDir + ", activity=" + activity + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((command == null) ? 0 : command.hashCode());
		result = prime * result
				+ ((workingDir == null) ? 0 : workingDir.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BaseExecCommand))
			return false;
		BaseExecCommand other = (BaseExecCommand) obj;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (command == null) {
			if (other.command != null)
				return false;
		} else if (!command.equals(other.command))
			return false;
		if (workingDir == null) {
			if (other.workingDir != null)
				return false;
		} else if (!workingDir.equals(other.workingDir))
			return false;
		return true;
	}
}
