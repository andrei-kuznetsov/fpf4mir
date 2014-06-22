package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class FileArtifact extends Artifact {

	/**
	 * 
	 */
	private static final long serialVersionUID = -795125536330647930L;

	public FileArtifact() {
		super();
	}

	public FileArtifact(Activity activity, String baseDir, String fileName) {
		super(activity, baseDir, fileName);
		validate(_getFile());
	}

	@Override
	public boolean isDirectory() {
		return false;
	}
	
	@Override
	public final void validate(File file) {
		if (file != null){
			if (!file.exists()){
				try {
					file.createNewFile();
				} catch (IOException e) {
					throw new RuntimeDroolsException("Can't create a file!", e);
				}
			} else if (file.isDirectory() == true){
				throw new RuntimeDroolsException("Artifact must be a file!");
			}
		}
	}

	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
