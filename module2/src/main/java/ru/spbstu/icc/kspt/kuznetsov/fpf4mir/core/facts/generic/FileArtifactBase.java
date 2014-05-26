package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;

public class FileArtifactBase extends FileArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = -6257256986473630550L;

	public FileArtifactBase() {
		super();
	}

	public FileArtifactBase(Activity activity, Artifact file) {
		super(activity, file);
	}

	public FileArtifactBase(Activity activity, File file) {
		super(activity, file);
	}

	public FileArtifactBase(Activity activity, FileArtifactAlias file) {
		super(activity, file);
	}

	public FileArtifactBase(Activity activity) {
		super(activity);
	}

	public FileArtifactBase(Artifact artifact) {
		super(artifact);
	}

}
