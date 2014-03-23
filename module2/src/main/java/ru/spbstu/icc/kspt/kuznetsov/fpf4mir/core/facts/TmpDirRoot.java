package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class TmpDirRoot extends FolderArtifact {

	public TmpDirRoot() {
		this(null);
	}

	public TmpDirRoot(File file) {
		super(R.id.TmpDirRoot, file);
	}

}
