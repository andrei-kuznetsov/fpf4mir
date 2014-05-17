package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;
import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class TmpDirRoot extends FolderArtifact {

	public TmpDirRoot() {
		this(null);
	}

	public TmpDirRoot(File file) {
		super(null, file);
	}

	public FolderArtifact newTempFolder(Activity activity){
		return new FolderArtifact(activity, new File(getFile(), UUID.randomUUID().toString()), false);
	}
}
