package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env;

import java.io.File;
import java.util.UUID;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.FolderArtifactBase;

public class DataDirRoot extends FolderArtifactBase {

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
