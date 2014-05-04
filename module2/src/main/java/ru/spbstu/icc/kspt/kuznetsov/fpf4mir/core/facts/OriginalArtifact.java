package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class OriginalArtifact extends Artifact {

	public OriginalArtifact() {
		super(R.id.OriginalArtifact);
	}

	public OriginalArtifact(File file) {
		super(R.id.OriginalArtifact, file);
	}

	public OriginalArtifact(Artifact other) {
		super(other);
		setId(R.id.OriginalArtifact);
	}
}
