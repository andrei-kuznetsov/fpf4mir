package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

import org.apache.tools.ant.DirectoryScanner;
import org.drools.RuntimeDroolsException;

public class FolderArtifact extends Artifact {
	private DirectoryScanner scanner = new DirectoryScanner();;

	public FolderArtifact() {
		super();
	}

	public FolderArtifact(String id, File file) {
		this(id, file, false);
	}
	
	public FolderArtifact(String id, File file, boolean exists) {
		super(id, file);
		if (exists) {
			if (file != null && file.exists()){
				setFile(file);
			} else {
				throw new RuntimeException("Folder '" + file.getAbsolutePath() + "' does not exist!");
			}
		} else {
			setFile(file);
		}
	}

	public FolderArtifact(String id) {
		super(id);
	}

	@Override
	public boolean isDirectory() {
		return true;
	}
	
	public void setDir(File dir){
		this.setFile(dir);
	}
	
	public File getDir() {
		return this.getFile();
	}

	public String[] getFileNamesForPattern(String... patterns){
		scanner.setIncludes(patterns);
		scanner.scan();
		return scanner.getIncludedFiles();
	}
	
	public String[] getDirNamesForPattern(String pattern){
		scanner.setIncludes(new String[]{pattern});
		scanner.scan();
		return scanner.getIncludedDirectories();
	}
	
	public FileArtifactList getFileArtifactListForPattern(String pattern){
		return getFileArtifactListForPattern(pattern, FileArtifact.class);
	}
	
	public FileArtifactList getFileArtifactListForPattern(String pattern, Class<? extends FileArtifact> c){
		String fileNames[] = getFileNamesForPattern(pattern);
		return new FileArtifactList(null, getDir(), fileNames, c);
	}
	
	@Override
	public final void setFile(File file) {
		if (file != null){
			if (!file.exists()){
				file.mkdir();
			} else if (file.isDirectory() == false){
				throw new RuntimeDroolsException("Artifact must be a directory!");
			}
		}
		super.setFile(file);

		scanner.setCaseSensitive(false);
		scanner.setBasedir(file);
	}

	@Override
	public String toString() {
		return "FolderArtifact [getAbsolutePath()=" + getAbsolutePath()
				+ ", getClass()=" + getClass() + "]";
	}
}
