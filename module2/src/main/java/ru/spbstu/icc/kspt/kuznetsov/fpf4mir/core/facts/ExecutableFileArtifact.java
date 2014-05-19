package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class ExecutableFileArtifact extends FileArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9000425303685318923L;
	
	private File workingDir;
	

	public ExecutableFileArtifact(Activity parentActivity, ExecutableFileArtifactAlias artifactAlias) {
		this(parentActivity, artifactAlias.getExecutableFile());
	}

	public ExecutableFileArtifact(File file, File workingDir) {
		super(null, file);
		this.workingDir = workingDir;
	}

	public ExecutableFileArtifact(File file) {
		super(null, file);
		this.workingDir = file.getParentFile();
	}
	
	public ExecutableFileArtifact(Activity parentActivity,
			ExecutableFileArtifact file) {
		super(parentActivity, file);
		workingDir = file.getWorkingDir();
	}

	public File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		this.workingDir = workingDir;
	}

	@Override
	public String toString() {
		return "RunExecutable [workingDir=" + workingDir + ", getFile()="
				+ getFile() + "]";
	}

}
