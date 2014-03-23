package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;

public class MvnRootPom extends FileArtifact{
	public MvnRootPom() {
		this((File)null);
	}

	protected MvnRootPom(File file) {
		super(R.id.MvnRootPom, file);
	}
	
	public MvnRootPom(FileArtifact artifact) {
		super(R.id.MvnRootPom, artifact.getFile());
	}
}
