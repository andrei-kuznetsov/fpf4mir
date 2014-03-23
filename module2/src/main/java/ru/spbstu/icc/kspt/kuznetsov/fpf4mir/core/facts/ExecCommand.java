package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.util.List;

public interface ExecCommand {
	public String getCommand();
	public Activity getActivity();
	public void setCommand(String command);
	public File getWorkingDir();
	public void setWorkingDir(File workingDir);
	
	public void addKey(String key);
	public void addKeyValue(String key, String value);
	
	public boolean hasKey(String key);

	public List<String> getArgsList();
}
