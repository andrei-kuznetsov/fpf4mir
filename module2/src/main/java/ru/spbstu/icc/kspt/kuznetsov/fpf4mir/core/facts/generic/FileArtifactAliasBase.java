package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class FileArtifactAliasBase extends ArtifactAliasBase implements FileArtifactAlias, ArtifactAlias{
	private FileArtifact file;
	
	public FileArtifactAliasBase(RequestFact request, String name,
			FileArtifact file) {
		super(request, name);
		this.file = file;
	}

	public FileArtifact getFile() {
		return file;
	}

	public void setFile(FileArtifact file) {
		this.file = file;
	}
}
