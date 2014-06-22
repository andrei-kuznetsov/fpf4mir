package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.util.ArrayList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class KeyValueArgument implements CmdLineArgument {
	private String key;
	private String value;
	private Activity activity;
	
	protected KeyValueArgument(Activity activity, String key, String value) {
		this.key = key;
		this.value = value;
		this.activity = activity;
	}

	@Override
	public List<String> getArguments() {
		List<String> res = new ArrayList<String>(3);
		res.add(key);
		res.add(value);
		return res;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return "KeyValueArgument [key=" + key + ", value=" + value + "]";
	}

}
