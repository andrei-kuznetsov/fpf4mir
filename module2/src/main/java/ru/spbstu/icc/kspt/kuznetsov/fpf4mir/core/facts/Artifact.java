package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.Serializable;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class Artifact implements Serializable, FPFCloneable, ActivityRelatedFact, FactWithName {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5672946567969136742L;
	
	private String fileName;
	private String baseDir;
	
	private Activity activity;
	private String name;
	
	private File _fileCache = null;
	
	protected Artifact(){
	}
	
	public Artifact(Activity activity, String baseDir, String fileName) {
		this.activity = activity;
		this.baseDir = baseDir;
		this.fileName = fileName;
	}

	protected Artifact(Artifact other){
		this.fileName = other.fileName;
		this.baseDir = other.baseDir;
		this.activity = other.activity;
	}

	public boolean isDirectory() {
		return _getFile().isDirectory();
	}
	/*
	public final boolean isAFile(){
		return !isDirectory();
	}*/
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
		_fileCache = null;
		this.validate(_getFile());
	}

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
		_fileCache = null;
		//this.validate(_getFile());
	}

	protected void validate(File _getFile) throws RuntimeDroolsException{
		// ok
	}

	public String getAbsolutePath() {
		return _getFile().getAbsolutePath();
	}
	
	public final File _getFile() {
		if (_fileCache == null){
			_fileCache = new File(baseDir, fileName);
		}
		return _fileCache;
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
		return getClass().getSimpleName() + " [name=" + name + ", fileName=" + fileName + ", activity=" + activity.toShortString() + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public Artifact reset(Activity activity, Artifact artifact){
		return this.reset(activity, null, artifact.baseDir, artifact.fileName);
	}

	public Artifact reset(Activity activity, String baseDir, String fileName) {
		return this.reset(activity, null, baseDir, fileName);
	}

	public Artifact reset(Activity activity, String name, String baseDir, String fileName) {
		this.activity = activity;
		this.baseDir = baseDir;
		this.fileName = fileName;
		this.name = name;
		validate(_getFile());
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((_getFile() == null) ? 0 : _getFile().hashCode());
		result = prime * result
				+ ((activity == null) ? 0 : activity.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Artifact other = (Artifact) obj;
		if (_getFile() == null) {
			if (other._getFile() != null)
				return false;
		} else if (!_getFile().equals(other._getFile()))
			return false;
		if (activity == null) {
			if (other.activity != null)
				return false;
		} else if (!activity.equals(other.activity))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

}
