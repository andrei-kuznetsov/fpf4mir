package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.Serializable;

import org.drools.RuntimeDroolsException;

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
	
	/*protected Artifact(Activity activity, File file) {
		this.activity = activity;
		this.file = file;
	}

	protected Artifact(){
		this(null, null);
	}
	
	protected Artifact(Activity activity) {
		this(activity, null);
	}*/
	

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
		return getClass().getSimpleName() + " [fileName=" + fileName + ", activity=" + activity + "]";
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	public void reset(Activity activity, Artifact artifact){
		this.reset(activity, artifact.baseDir, artifact.fileName);
	}

	public void reset(Activity activity, String baseDir, String fileName) {
		this.activity = activity;
		this.baseDir = baseDir;
		this.fileName = fileName;
		validate(_getFile());
	}
	
}
