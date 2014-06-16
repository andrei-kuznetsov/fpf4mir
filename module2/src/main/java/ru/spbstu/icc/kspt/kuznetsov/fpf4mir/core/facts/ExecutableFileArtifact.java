package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;

public class ExecutableFileArtifact extends FileArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 9000425303685318923L;
	
	private File workingDir;
	
	public ExecutableFileArtifact() {

	}

	public File getWorkingDir() {
		return workingDir;
	}

	public void setWorkingDir(File workingDir) {
		this.workingDir = workingDir;
	}

	@Override
	public void setFileName(String fileName) {
		super.setFileName(fileName);
		if (workingDir == null){
			setWorkingDir(_getFile().getParentFile());
		}
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName() + " [workingDir=" + workingDir + ", getFile()="
				+ _getFile() + "]";
	}

/*######################################################################################
 *  Empty methods for compatibility with Drools (otherwise it's not possible to set 
 * properties via FactField because Drools doesn't look for methods in super classes
 *######################################################################################*/
	@Override
	public void setBaseDir(String baseDir) {
		super.setBaseDir(baseDir);
	}
	
	@Override
	public String getBaseDir() {
		return super.getBaseDir();
	}

	@Override
	public String getFileName() {
		return super.getFileName();
	}

	@Override
	public Activity getActivity() {
		return super.getActivity();
	}

	@Override
	public void setActivity(Activity activity) {
		super.setActivity(activity);
	}
	
	
}
