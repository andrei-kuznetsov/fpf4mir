package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class ArtifactRefBase extends ActivityRelatedFactBase implements ArtifactRef {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2243838108487140964L;
	
	private URI ref;
	private String name;

	protected ArtifactRefBase() {
	}
	
	protected ArtifactRefBase(Activity activity, URI ref) {
		super(activity);
		this.ref = ref;
	}

	protected ArtifactRefBase(Activity activity, ArtifactRef ref) {
		this(activity, ref.getRef());
	}
	
	public URI getRef() {
		return ref;
	}

	public void setRef(URI ref) {
		this.ref = ref;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + "[ref=" + ref + "]";
	}
	
	public ArtifactRefBase reset(Activity activity, String name, String uri) {
		super.reset(activity);
		this.setName(name);
		this.setRef(URI.create(uri));
		
		return this;
	}
	
}
