package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class DownloadAction extends ActionFactBase implements ActionFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = -7325427898452609169L;
	private URI uri;
	private String id;
	
	public DownloadAction(Activity activity, String id, URI uri) {
		super(activity);
		this.id = id;
		this.uri = uri;
	}

	public DownloadAction(Activity activity) {
		super(activity);
	}

	public URI getUri() {
		return uri;
	}

	public void setUri(URI uri) {
		this.uri = uri;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
