package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class Artifact {
	private File file;
	private Activity activity;
	
	protected Artifact(Activity activity, File file) {
		this.activity = activity;
		this.file = file;
	}

	protected Artifact(){
		this(null, null);
	}
	
	protected Artifact(Activity activity) {
		this(activity, null);
	}
	
	
	protected Artifact(Artifact other){
		this.file = other.file;
		this.activity = other.activity;
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

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [file=" + file + ", activity=" + activity + "]";
	}
}
