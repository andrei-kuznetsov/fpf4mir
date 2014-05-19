package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class FileArtifactAliasBase extends ArtifactAliasBase implements FileArtifactAlias, ArtifactAlias{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8580269831255114226L;
	
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

	public FileArtifact cloneArtifact(Activity newActivity) {
		FileArtifact copy = org.apache.commons.lang3.SerializationUtils.clone(this.getFile());
		copy.setActivity(newActivity);
		return copy;
	}

	public FileArtifact cloneArtifact(Activity newActivity, String newName) {
		FileArtifact copy = org.apache.commons.lang3.SerializationUtils.clone(this.getFile());
		copy.setActivity(newActivity);
		copy.setName(newName);
		return copy;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [file=" + file + ", getName()="
				+ getName() + "]";
	}
}
