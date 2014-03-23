package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class Artifact {
	private File file;
	private String id;
	
	protected Artifact() {
		this(null, null);
	}

	protected Artifact(String id) {
		this(id, null);
	}
	
	protected Artifact(String id, File file) {
		this.id = id;
		this.file = file;
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}
	
	public String getFileName() {
		return file.getName();
	}

	public String getAbsolutePath() {
		return file.getAbsolutePath();
	}
	
	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Artifact [id=" + id + ", file=" + file + "]";
	}
}
