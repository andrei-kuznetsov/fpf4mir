package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base;

import java.io.File;
import java.io.IOException;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.MaterializableFileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class MaterializableFileArtifactListBase extends FileArtifactListBase implements MaterializableFileArtifactList{
	private static final long serialVersionUID = 1L;
	private FolderArtifact baseDir;
	private FolderArtifact tmpDir;
	private File materializedFile;

	public MaterializableFileArtifactListBase() {
	}
	
	public MaterializableFileArtifactListBase(Activity activity, FolderArtifact baseDir, String pattern, FolderArtifact tmpDir) {
		super(activity, baseDir.getFileArtifactListForPattern(pattern));
		this.baseDir = baseDir;
		this.tmpDir = tmpDir;
	}
	
	public String getAbsolutePath(){

		if (materializedFile == null && tmpDir != null){
			materializedFile = materialize(tmpDir._getFile());
		}

		if (materializedFile != null) {
			return materializedFile.getAbsolutePath();
		} else {
			return null;
		}
	}

	private File materialize(File tmpDir){
		java.io.File list = new java.io.File(tmpDir, java.util.UUID.randomUUID().toString());
		java.io.FileWriter fwr;
		try {
			fwr = new java.io.FileWriter(list, false);
			for (FileArtifact i : this.list()){
				fwr.write(i.getAbsolutePath());
				fwr.write('\n');
			}
			fwr.close();
		} catch (IOException e) {
			throw new RuntimeDroolsException("Can't materialize filelist", e);
		}
		
		return list;
	}
	
	public MaterializableFileArtifactListBase reset(Activity activity, FolderArtifact baseDir, String pattern, FolderArtifact tmpDir){
		super.reset(activity, baseDir.getFileArtifactListForPattern(pattern));
		this.baseDir = baseDir;
		this.tmpDir = tmpDir;
		return this;
	}
	
	@Override
	public String toString() {
		return getClass() + " [baseDir=" + baseDir
				+ ", materializedFile=" + materializedFile + "]";
	}
}
