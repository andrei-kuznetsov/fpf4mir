package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class TestRunDataRef extends ArtifactRef {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8137291008869655514L;

	public TestRunDataRef(Activity activity, URI ref) {
		super(activity, ref);
	}

}
