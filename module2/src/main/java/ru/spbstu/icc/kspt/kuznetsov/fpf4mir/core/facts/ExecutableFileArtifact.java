package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class ExecutableFileArtifact extends FileArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9000425303685318923L;
	
	private FolderArtifact workingDir;
	
	public ExecutableFileArtifact() {

	}

	public FolderArtifact getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(FolderArtifact workingDir) {
		this.workingDir = workingDir;
	}

	@Override
	public void setFileName(String fileName) {
		super.setFileName(fileName);
		if (workingDir == null){
			setWorkingDir(new FolderArtifact(getActivity(), _getFile().getParent(), ""));
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [workingDir=" + workingDir + ", getFile()="
				+ _getFile() + "]";
	}
	
	public ExecutableFileArtifact reset(Activity activity, ExecutableFileArtifact artifact){
		super.reset(activity, artifact);
		this.workingDir = artifact.getWorkingDir();
		return this;
	}
}
