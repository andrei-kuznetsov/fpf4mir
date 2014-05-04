package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class TmpDirRoot extends FolderArtifact {

	public TmpDirRoot() {
		this(null);
	}

	public TmpDirRoot(File file) {
		super(null, file);
	}

}
