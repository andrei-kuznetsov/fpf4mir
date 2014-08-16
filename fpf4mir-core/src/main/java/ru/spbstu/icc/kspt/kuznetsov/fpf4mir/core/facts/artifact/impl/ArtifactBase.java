package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl;

import java.io.File;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;

public class ArtifactBase extends ActivityRelatedFactBase implements Artifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5672946567969136742L;
	
	private String fileName;
	private String baseDir;
	
	private String name;
	
	private File _fileCache = null;
	
	protected ArtifactBase(){
	}
	
	protected ArtifactBase(Activity activity, String baseDir, String fileName) {
		super(activity);
		this.baseDir = baseDir;
		this.fileName = fileName;
	}

	protected ArtifactBase(Artifact other){
		super(other.getActivity());
		this.fileName = other.getFileName();
		this.baseDir = other.getBaseDir();
	}

	public boolean isDirectory() {
		return _getFile().isDirectory();
	}
	
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
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [name=" + name + ", fileName=" + fileName + ", activity=" + getActivity().toShortString() + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public ArtifactBase reset(Activity activity, Artifact artifact){
		return this.reset(activity, null, artifact.getBaseDir(), artifact.getFileName());
	}

	public ArtifactBase reset(Activity activity, String baseDir, String fileName) {
		return this.reset(activity, null, baseDir, fileName);
	}

	public ArtifactBase reset(Activity activity, String name, String baseDir, String fileName) {
		super.reset(activity);
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
				+ ((getActivity() == null) ? 0 : getActivity().hashCode());
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
		if (getActivity() == null) {
			if (other.getActivity() != null)
				return false;
		} else if (!getActivity().equals(other.getActivity()))
			return false;
		if (name == null) {
			if (other.getName() != null)
				return false;
		} else if (!name.equals(other.getName()))
			return false;
		return true;
	}

}
