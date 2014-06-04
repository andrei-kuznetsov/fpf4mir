package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecCommand;

public class ExecAction extends ActionFactBase implements ActionFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3625795389816472639L;
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

	public ExecCommand getExecCommand() {
		return execCommand;
	}

	public void setExecCommand(ExecCommand execCommand) {
		this.execCommand = execCommand;
	}
}
