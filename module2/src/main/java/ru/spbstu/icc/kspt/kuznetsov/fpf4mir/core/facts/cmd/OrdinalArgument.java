package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.MaterializableFileArtifactListBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class OrdinalArgument extends ActivityRelatedFactBase implements CmdLineArgument, Comparable<OrdinalArgument>, Serializable, FPFCloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7563903193611604495L;
	private int order;
	private String value;
	
	public OrdinalArgument(Activity activity) {
		this(activity, "");
	}

	public OrdinalArgument(Activity activity, int order, String value) {
		super(activity);
		this.order = order;
		this.value = value;
	}

	public OrdinalArgument(Activity activity, int order, Artifact artifact) {
		this(activity, order, artifact._getFile().getAbsolutePath());
	}

	public OrdinalArgument(Activity activity, int order, MaterializableFileArtifactListBase flist) {
		this(activity, order, flist.getAbsolutePath());
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
	public int compareTo(OrdinalArgument o) {
		return Integer.compare(order, o.order);
	}
}
