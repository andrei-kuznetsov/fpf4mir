package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

public interface ExecCommand extends ActivityRelatedFact {
	public String getCommand();
	public void setCommand(String command);
	public File getWorkingDir();
	public void setWorkingDir(File workingDir);
	
	public void addKey(String key);
	public void addKeyValue(String key, String value);
	
	public boolean hasKey(String key);

	public List<String> getArgsList();
}
