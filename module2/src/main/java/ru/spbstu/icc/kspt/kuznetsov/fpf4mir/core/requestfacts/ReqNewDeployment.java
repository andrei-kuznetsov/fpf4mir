package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DeployActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class ReqNewDeployment extends RequestFactBase implements ReqNewActivity {
	private FileArtifact file;
	private FolderArtifact folder;
	private ArtifactRef artifactRef;

	@Override
	public String toString() {
		return "ReqNewDeployment [file=" + file + ", folder=" + folder
				+ ", artifactUrl=" + artifactRef + "]";
	}

	public FileArtifact getFile() {
		return file;
	}

	public void setFile(FileArtifact file) {
		this.file = file;
	}

	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}


	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}

	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}

	@Override
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new DeployActivity((int)date.getTime(), date, this);
	}
	
}
