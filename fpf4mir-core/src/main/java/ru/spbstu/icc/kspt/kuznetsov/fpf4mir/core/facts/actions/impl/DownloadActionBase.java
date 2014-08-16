package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class DownloadActionBase extends ActionFactBase implements DownloadAction {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7325427898452609169L;
	private URI uri;
	
	protected DownloadActionBase(Activity activity, URI uri) {
		super(activity);
		this.uri = uri;
	}

	protected DownloadActionBase(Activity activity) {
		super(activity);
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}
	
}
