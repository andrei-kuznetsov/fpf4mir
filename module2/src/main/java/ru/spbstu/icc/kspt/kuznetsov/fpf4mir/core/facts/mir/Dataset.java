package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class Dataset extends FolderArtifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8836980620067197908L;
	
	public Dataset() {
		super();
	}

	public Dataset(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
	}

}
