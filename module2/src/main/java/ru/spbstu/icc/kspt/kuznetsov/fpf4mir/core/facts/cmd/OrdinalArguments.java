package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class OrdinalArguments extends ActivityRelatedFactBase implements CmdLineArgument, Comparable<OrdinalArguments> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7475586381895478722L;
	
	private int order;
	private List<String> values = new LinkedList<String>();
	
	public OrdinalArguments(){
	}
	
	public OrdinalArguments(Activity activity) {
		this(activity, 0);
	}

	public OrdinalArguments(Activity activity, int order) {
		super(activity);
		this.order = order;
	}

	public OrdinalArguments(Activity activity, int order, List<String> values) {
		this(activity, order);
		this.values.addAll(values);
	}

	public OrdinalArguments(Activity activity, int order, String value) {
		this(activity, order);
		this.values.add(value);
	}

	public OrdinalArguments(Activity activity, String value) {
		this(activity, 0, value);
	}
	
	public int getOrder() {
		return order;
	}

	public void setOrder(int order) {
		this.order = order;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [order=" + order + ", values=" + new HashSet<String>(values) + "]";
	}

	@Override
	public List<String> getArguments() {
		return values;
	}

	@Override
	public int compareTo(OrdinalArguments o) {
		return Integer.compare(order, o.order);
	}

	public OrdinalArguments reset(Activity activity, List<String> list){
		super.reset(activity);
		values.clear();
		values.addAll(list);
		return this;
	}
}
