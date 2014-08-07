package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class GenericArtifactRef extends ArtifactRefBase implements ArtifactRef{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2497998652527264721L;

	public GenericArtifactRef() {
		super();
	}

	public GenericArtifactRef(Activity activity, ArtifactRef ref) {
		super(activity, ref);
	}

	public GenericArtifactRef(Activity activity, URI ref) {
		super(activity, ref);
	}

}
