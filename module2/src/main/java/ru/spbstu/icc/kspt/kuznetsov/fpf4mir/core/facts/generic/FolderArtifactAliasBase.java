package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public class FolderArtifactAliasBase extends ArtifactAliasBase implements FolderArtifactAlias{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5886056271991242941L;
	
	private FolderArtifact folder;
	
	public void reset(RequestFact request, RequestStatus rstatus, String name, FolderArtifact folder) {
		super.reset(request, rstatus, name);
		this.folder = folder;
	}

	public void reset(RequestFact request, String name, FolderArtifact folder) {
		this.reset(request, null, name, folder);
	}

	public void reset(RequestStatus rstatus, String name, FolderArtifact folder) {
		this.reset(null, rstatus, name, folder);
	}
	
	public void reset(RequestFact request, FolderArtifactAlias folder) {
		this.reset(request, folder.getName(), folder.getFolder());
	}

	public void reset(RequestFact request, FolderArtifact folder) {
		this.reset(request, folder.getName(), folder);
	}

	public void reset(RequestStatus rstatus, FolderArtifact folder) {
		this.reset(rstatus, folder.getName(), folder);
	}
	
	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}

	public FolderArtifact cloneArtifact(Activity newActivity) {
		FolderArtifact copy;
		try {
			copy = (FolderArtifact) this.getFolder().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
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
