package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public class FileArtifact extends Artifact implements FPFCloneable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -795125536330647930L;

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

	public FileArtifact(Activity activity, FileArtifactAlias file) {
		this(activity, file.getRefObject());
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
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
}
