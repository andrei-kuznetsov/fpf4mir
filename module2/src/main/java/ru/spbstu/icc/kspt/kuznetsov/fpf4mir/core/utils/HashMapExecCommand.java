package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.File;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class HashMapExecCommand extends BaseExecCommand{
	private Map<String, String> arguments = new HashMap<String, String>();
	
	public HashMapExecCommand() {
		super();
	}

	public HashMapExecCommand(Activity activity, String command, File workingDir) {
		super(activity, command, workingDir);
	}

	public HashMapExecCommand(Activity activity, String command) {
		super(activity, command);
	}

	public List<String> getArgsList() {
        List<String> args = new LinkedList<String>();
        
        for (Entry<String, String> i : arguments.entrySet()){
        	if (i.getKey() != null){
        		if (i.getValue() != null){
        			if (i.getValue().startsWith("=")){
        				args.add(i.getKey() + i.getValue());
        			} else {
                		args.add(i.getKey());
        				args.add(i.getValue());
        			}
            	} else {
            		args.add(i.getKey());
            	}
        	}
        }
        
        return args;
	}

	@Override
	public String toString() {
		return "HashMapExecCommand [arguments=" + arguments + ", toString()="
				+ super.toString() + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((arguments == null) ? 0 : arguments.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof HashMapExecCommand))
			return false;
		HashMapExecCommand other = (HashMapExecCommand) obj;
		if (arguments == null) {
			if (other.arguments != null)
				return false;
		} else if (!arguments.equals(other.arguments))
			return false;
		return true;
	}

	@Override
	public void addKey(String key) {
		arguments.put(key, null);
	}

	@Override
	public void addKeyValue(String key, String value) {
		arguments.put(key, value);
	}

	@Override
	public boolean hasKey(String key) {
		return arguments.containsKey(key);
	}
}