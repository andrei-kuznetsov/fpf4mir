package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;

public interface ExecAction extends Action {

	public String getCommand();
	public File getWorkingDir();
	public List<String> getArguments();
	
	public ExecCommand getExecCommand();
	public void setExecCommand(ExecCommand execCommand);
}
