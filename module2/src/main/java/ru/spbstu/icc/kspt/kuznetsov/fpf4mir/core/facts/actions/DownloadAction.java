package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import java.net.URI;

public interface DownloadAction extends ActionFact {

	public URI getUri();
	public void setUri(URI uri);
	
}
