package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;
import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class DataDirRoot extends FolderArtifact {

	public DataDirRoot() {
		this(null);
	}

	public DataDirRoot(File file) {
		super(null, file);
	}

	public File newFolder(String preffix) {
		String fn = preffix + UUID.randomUUID().toString();
		File f = new File(getDir(), fn);
		return f;
	}
	
	public File newFolder() {
		return newFolder("");
	}


}
