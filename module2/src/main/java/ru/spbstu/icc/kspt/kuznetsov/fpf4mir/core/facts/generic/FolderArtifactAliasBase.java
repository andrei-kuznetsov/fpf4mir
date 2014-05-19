package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class FolderArtifactAliasBase extends ArtifactAliasBase implements FolderArtifactAlias{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5886056271991242941L;
	
	private FolderArtifact folder;
	
	public FolderArtifactAliasBase(RequestFact request, String name,
			FolderArtifact folder) {
		super(request, name);
		this.folder = folder;
	}

	public FolderArtifactAliasBase(RequestFact request, FolderArtifactAlias folder) {
		super(request, folder);
		this.folder = folder.getFolder();
	}
	
	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}

	public FolderArtifact cloneArtifact(Activity newActivity) {
		FolderArtifact copy = org.apache.commons.lang3.SerializationUtils.clone(this.getFolder());
		copy.setActivity(newActivity);
		return copy;
	}

	public FolderArtifact cloneArtifact(Activity newActivity, String newName) {
		FolderArtifact copy = org.apache.commons.lang3.SerializationUtils.clone(this.getFolder());
		copy.setActivity(newActivity);
		copy.setName(newName);
		return copy;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [folder=" + folder + ", getName()="
				+ getName() + "]";
	}
}
