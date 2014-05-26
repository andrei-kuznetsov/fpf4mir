package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class Artifact implements Serializable, FPFCloneable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5672946567969136742L;
	
	private File file;
	private Activity activity;
	private String name;
	
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
	
	public final boolean isAFile(){
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [file=" + file + ", activity=" + activity + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void reset(Activity activity, Artifact artifact){
		setActivity(activity);
		setFile(artifact.getFile());
		setName(artifact.getName());
	}
}
