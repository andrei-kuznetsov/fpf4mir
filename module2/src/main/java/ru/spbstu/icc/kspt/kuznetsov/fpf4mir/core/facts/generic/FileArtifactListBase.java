package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.File;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class FileArtifactListBase extends FileArtifactList{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493200466299237227L;

	public FileArtifactListBase() {
	}
	
	public FileArtifactListBase(Activity activity, FileArtifactList list) {
		super(activity, list);
	}

	public FileArtifactListBase(Activity activity, String listName,
			File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		super(activity, listName, baseDir, fileNames, c);
	}

	public FileArtifactListBase(Activity activity, String listName,
			File baseDir, String[] fileNames) {
		super(activity, listName, baseDir, fileNames);
	}

	public void reset(Activity activity, List list){
		this.clear();
		setActivity(activity);
		setName("default");
		addAll(list);
	}

	public void reset(Activity activity, FileArtifactList list){
		this.clear();
		setActivity(activity);
		setName("default");
		addAll(list.list());
	}
}
