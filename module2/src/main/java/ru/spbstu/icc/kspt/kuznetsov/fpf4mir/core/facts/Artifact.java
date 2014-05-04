package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class Artifact {
	private File file;
	private Activity activity;
	
	@Deprecated
	private String id;
	
	protected Artifact(Activity activity, File file) {
		this.activity = activity;
		this.file = file;
	}

	protected Artifact(){
		this((Activity)null, null);
	}
	
	protected Artifact(String id) {
		this(id, null);
	}
	
	@Deprecated
	protected Artifact(String id, File file) {
		this.id = id;
		this.file = file;
	}
	
	protected Artifact(Artifact other){
		this.file = other.file;
		this.id = other.id;
	}

	public boolean isDirectory() {
		return file.isDirectory();
	}
	
	public final boolean isFile(){
		return !isDirectory();
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

	@Deprecated
	public String getId() {
		return id;
	}

	@Deprecated
	public void setId(String id) {
		this.id = id;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [file=" + file + ", activity=" + activity + ", id="
				+ id + "]";
	}
}
