package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecutableFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecutableFileArtifactAlias;

public class ExecutableFileArtifactAliasBase extends FileArtifactAliasBase implements ExecutableFileArtifactAlias{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3541340636630984099L;
	
	@Override
	public ExecutableFileArtifact getExecutableFile() {
		return (ExecutableFileArtifact) getFile();
	}

	@Override
	public void setExecutableFile(ExecutableFileArtifact file) {
		setFile(file);
	}

}
