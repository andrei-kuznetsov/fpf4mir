package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.ExecCommand;


public interface ExecStatus extends ActionStatus {

	public FileArtifact getFileOut();
	public FileArtifact getFileErr();
	
	public String getSingleLineFromOut(String pattern);
	public String getSingleLineFromErr(String pattern);
	public String getSingleLine(String pattern);
	
	public boolean containsString(String pattern);
	
	public int getStatus();
	public void setStatus(int status);

	public ExecCommand getExecCommand();
	public void setExecCommand(ExecCommand execCommand);
}
