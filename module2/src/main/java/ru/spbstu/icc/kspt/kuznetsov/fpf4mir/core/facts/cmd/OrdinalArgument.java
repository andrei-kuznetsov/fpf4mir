package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.util.ArrayList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class OrdinalArgument implements CmdLineArgument, Comparable<OrdinalArgument> {
	private int order;
	private String value;
	private Activity activity;
	
	public OrdinalArgument(Activity activity) {
		this(activity, "");
	}

	public OrdinalArgument(Activity activity, int order, String value) {
		this.order = order;
		this.value = value;
		this.activity = activity;
	}

	public OrdinalArgument(Activity activity, String value) {
		this(activity, 0, value);
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
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
		return "OrdinalArgument [order=" + order + ", value=" + value + "]";
	}

	@Override
	public List<String> getArguments() {
		List<String> res = new ArrayList<String>(2);
		res.add(value);
		return res;
	}

	@Override
	public int compareTo(OrdinalArgument o) {
		return Integer.compare(order, o.order);
	}

}
