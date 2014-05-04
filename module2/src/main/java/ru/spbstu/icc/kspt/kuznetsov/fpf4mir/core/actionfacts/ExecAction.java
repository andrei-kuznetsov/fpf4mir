package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecCommand;

public class ExecAction extends ActionFactBase implements ActionFact {
	private String id;
	private ExecCommand execCommand;

	public ExecAction(String id, ExecCommand command) {
		super(command.getActivity());
		this.id = id;
		this.execCommand = command;
	}

	public ExecAction(ExecCommand command) {
		this(null, command);
	}
	
	public String getCommand() {
		return execCommand.getCommand();
	}

	public File getWorkingDir() {
		return execCommand.getWorkingDir();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<String> getArguments() {
		return execCommand.getArgsList();
	}

	@Override
	public String toString() {
		return "ExecAction [id=" + id + ", execCommand=" + execCommand
				+ ", activity=" + getActivity() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((execCommand == null) ? 0 : execCommand.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ExecAction other = (ExecAction) obj;
		if (execCommand == null) {
			if (other.execCommand != null)
				return false;
		} else if (!execCommand.equals(other.execCommand))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public ExecCommand getExecCommand() {
		return execCommand;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.execCommand = execCommand;
	}
}
