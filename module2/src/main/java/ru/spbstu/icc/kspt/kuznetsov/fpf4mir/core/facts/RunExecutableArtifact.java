package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class RunExecutableArtifact extends FileArtifact{
	private File workingDir;
	
	public RunExecutableArtifact() {
		this(null, null);
	}

	public RunExecutableArtifact(File file, File workingDir) {
		super(R.id.RunArtifact, file);
		this.workingDir = workingDir;
	}

	public RunExecutableArtifact(File file) {
		super(R.id.RunArtifact, file);
		this.workingDir = file.getParentFile();
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((workingDir == null) ? 0 : workingDir.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof RunExecutableArtifact))
			return false;
		RunExecutableArtifact other = (RunExecutableArtifact) obj;
		if (workingDir == null) {
			if (other.workingDir != null)
				return false;
		} else if (!workingDir.equals(other.workingDir))
			return false;
		return true;
	}

}
