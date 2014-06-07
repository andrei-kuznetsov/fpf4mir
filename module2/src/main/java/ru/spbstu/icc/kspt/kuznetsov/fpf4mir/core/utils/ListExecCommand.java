package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.File;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class ListExecCommand extends BaseExecCommand{
	/**
	 * 
	 */
	private static final long serialVersionUID = -9143661806870839936L;
	private List<String> arguments = new LinkedList<String>();
	
	public ListExecCommand() {
		super();
	}

	public ListExecCommand(Activity activity, String command, File workingDir) {
		super(activity, command, workingDir);
	}

	public ListExecCommand(Activity activity, String command, FolderArtifact workingDir,
			List<OrdinalArgument> arguments) {
		super(activity, command, workingDir._getFile());
		
		Collections.sort(arguments);
		for (OrdinalArgument i : arguments){
			this.arguments.addAll(i.getArguments());
		}
	}

	public ListExecCommand(Activity activity, String command) {
		super(activity, command);
	}

	public List<String> getArgsList() {
        return arguments;
	}

	@Override
	public void addKey(String key) {
		arguments.add(key);
	}

	@Override
	public void addKeyValue(String key, String value) {
		arguments.add(key);
		arguments.add(value);
	}

	@Override
	public boolean hasKey(String key) {
		return arguments.contains(key);
	}
}
