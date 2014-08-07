package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.MaterializableFileArtifactListBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.CmdLineArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public final class GenericOrdinalArgument extends ActivityRelatedFactBase implements CmdLineArgument, Comparable<GenericOrdinalArgument>, Serializable, FPFCloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7563903193611604495L;
	private int order;
	private String value;
	
	public GenericOrdinalArgument(Activity activity) {
		this(activity, "");
	}

	public GenericOrdinalArgument(Activity activity, int order, String value) {
		super(activity);
		this.order = order;
		this.value = value;
	}

	public GenericOrdinalArgument(Activity activity, int order, Artifact artifact) {
		this(activity, order, artifact._getFile().getAbsolutePath());
	}

	public GenericOrdinalArgument(Activity activity, int order, MaterializableFileArtifactListBase flist) {
		this(activity, order, flist.getAbsolutePath());
	}
	
	public GenericOrdinalArgument(Activity activity, String value) {
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

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [order=" + order + ", value=" + value + "]";
	}

	@Override
	public List<String> getArguments() {
		List<String> res = new ArrayList<String>(2);
		res.add(value);
		return res;
	}

	@Override
	public int compareTo(GenericOrdinalArgument o) {
		return Integer.compare(order, o.order);
	}
}
