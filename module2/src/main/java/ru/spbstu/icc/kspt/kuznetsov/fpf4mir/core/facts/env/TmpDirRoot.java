package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R.id;

public class TmpDirRoot extends FolderArtifact {

	public TmpDirRoot() {
		this(null);
	}

	public TmpDirRoot(File file) {
		super(R.id.TmpDirRoot, file);
	}

}
