package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import java.net.URI;

public class DownloadAction implements ActionFact {
	private URI uri;
	private String id;
	
	public DownloadAction(String id, URI uri) {
		this.id = id;
		this.uri = uri;
	}

	public DownloadAction() {
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
