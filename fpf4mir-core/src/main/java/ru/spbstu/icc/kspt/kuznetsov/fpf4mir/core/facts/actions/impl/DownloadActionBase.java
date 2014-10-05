package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class DownloadActionBase extends ActionFactBase<ArtifactRef> implements DownloadAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7325427898452609169L;
	
	protected DownloadActionBase(Activity activity, ArtifactRef uri) {
		super(activity);
		this.parameter = uri;
	}

	protected DownloadActionBase(Activity activity) {
		super(activity);
	}

	public URI getUri() {
		return parameter.getRef();
	}
	
}
