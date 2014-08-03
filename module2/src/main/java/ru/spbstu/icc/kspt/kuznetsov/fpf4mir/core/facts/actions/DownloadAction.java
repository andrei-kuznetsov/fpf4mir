package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import java.net.URI;

public interface DownloadAction extends Action {

	public URI getUri();
	public void setUri(URI uri);
	
}
