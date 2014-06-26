package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.Serializable;
import java.net.URI;
import java.net.URISyntaxException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class ArtifactRef implements ActivityRelatedFact, FactWithName, FPFCloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2243838108487140964L;
	
	private URI ref;
	private Activity activity;
	private String name;

	public ArtifactRef() {
	}
	
	public ArtifactRef(Activity activity, URI ref) {
		this.activity = activity;
		this.ref = ref;
	}

	public ArtifactRef(Activity activity, ArtifactRef ref) {
		this(activity, ref.getRef());
	}
	
	public ArtifactRef(Activity activity, ArtifactRefAlias ref) {
		this(activity, ref.getRefObject());
	}

	public URI getRef() {
		return ref;
	}

	public void setRef(URI ref) {
		this.ref = ref;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}
