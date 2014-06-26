package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.FileArtifactListBase;

public class GenericFileArtifactList extends FileArtifactListBase {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6919524106758582191L;

	public GenericFileArtifactList() {
		super();
	}

	public GenericFileArtifactList(Activity activity, FileArtifactList list) {
		super(activity, list);
	}

	public GenericFileArtifactList(Activity activity, String listName,
			File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		super(activity, listName, baseDir, fileNames, c);
	}

	public GenericFileArtifactList(Activity activity, String listName,
			File baseDir, String[] fileNames) {
		super(activity, listName, baseDir, fileNames);
	}

}
