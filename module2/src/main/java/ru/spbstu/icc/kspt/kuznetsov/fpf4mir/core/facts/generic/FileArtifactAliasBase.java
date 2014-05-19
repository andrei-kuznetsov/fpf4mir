package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public class FileArtifactAliasBase extends ArtifactAliasBase implements FileArtifactAlias, ArtifactAlias{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8580269831255114226L;
	
	private FileArtifact file;

	public void reset(RequestFact request, RequestStatus rstatus, String name, FileArtifact file) {
		super.reset(request, rstatus, name);
		this.file = file;
	}
	
	public void reset(RequestFact request, String name, FileArtifact file) {
		this.reset(request, null, name, file);
	}

	public void reset(RequestStatus rstatus, String name, FileArtifact file) {
		this.reset(null, rstatus, name, file);
	}
	
	public void reset(RequestFact request, FileArtifact file) {
		this.reset(request, file.getName(), file);
	}

	public void reset(RequestStatus rstatus, FileArtifact file) {
		this.reset(rstatus, file.getName(), file);
	}
	
	public FileArtifact getFile() {
		return file;
	}

	public void setFile(FileArtifact file) {
		this.file = file;
	}

	public FileArtifact cloneArtifact(Activity newActivity) {
		FileArtifact copy = null;
		try {
			copy = (FileArtifact) this.getFile().clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		copy.setActivity(newActivity);
		return copy;
	}

	public FileArtifact cloneArtifact(Activity newActivity, String newName) {
		FileArtifact copy = cloneArtifact(newActivity);
		copy.setName(newName);
		return copy;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [file=" + file + ", getName()="
				+ getName() + "]";
	}
}
