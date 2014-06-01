package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;
import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class DataDirRoot extends FolderArtifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7421361020255004712L;

	public DataDirRoot() {
	}

	public DataDirRoot(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

	public File newFolder(String preffix) {
		String fn = preffix + UUID.randomUUID().toString();
		File f = new File(_getFile(), fn);
		return f;
	}
	
	public File newFolder() {
		return newFolder("");
	}


}
