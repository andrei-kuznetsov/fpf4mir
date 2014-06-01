package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class ExecutableFileArtifact extends FileArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9000425303685318923L;
	
	private File workingDir;
	
	public ExecutableFileArtifact() {

	}

	public File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		this.workingDir = workingDir;
	}

	@Override
	public void setFileName(String fileName) {
		super.setFileName(fileName);
		if (workingDir == null){
			setWorkingDir(_getFile().getParentFile());
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [workingDir=" + workingDir + ", getFile()="
				+ _getFile() + "]";
	}

}
