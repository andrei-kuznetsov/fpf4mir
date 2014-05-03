package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.OriginalArtifact;

public class ReqNewOriginalArtifact extends RequestFactBase implements RequestFact {
	private OriginalArtifact originalArtifact;

	public ReqNewOriginalArtifact(File oa) {
		originalArtifact = new OriginalArtifact(oa);
	}

	public OriginalArtifact getOriginalArtifact() {
		return originalArtifact;
	}

	public void setOriginalArtifact(OriginalArtifact artifact) {
		this.originalArtifact = artifact;
	}
}
