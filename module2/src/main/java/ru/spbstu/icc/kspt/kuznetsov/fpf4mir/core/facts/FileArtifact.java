package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;

import org.drools.RuntimeDroolsException;

public class FileArtifact extends Artifact {

	public FileArtifact() {
		super();
	}

	public FileArtifact(Activity activity, File file) {
		super(activity, file);
		setFile(file);
	}

	public FileArtifact(Activity activity, Artifact file) {
		this(activity, file.getFile());
	}

	public FileArtifact(Artifact artifact) {
		this(artifact.getActivity(), artifact.getFile());
	}
	
	public FileArtifact(Activity activity) {
		super(activity);
	}

	@Override
	public boolean isDirectory() {
		return false;
	}
	
	@Override
	public void setFile(File file) {
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
		super.setFile(file);
	}

	@Override
	public String toString() {
		return "FileArtifact [toString()=" + super.toString() + "]";
	}
}
