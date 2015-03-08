package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public interface DownloadAction extends Action<ArtifactRef> {

	public URI getUri();
	
}
