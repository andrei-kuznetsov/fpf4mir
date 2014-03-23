package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.drools.RuntimeDroolsException;

public class FileArtifactList extends ArrayList<FileArtifact>{
	private static final long serialVersionUID = 1L;
	
	private String id;

	public FileArtifactList(String id, File baseDir, String fileNames[]) {
		this(id, baseDir, fileNames, FileArtifact.class);
	}
	
	protected FileArtifactList(String id, FileArtifactList list) {
		super(list);
		this.id = id;
	}

	public FileArtifactList(String id, File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		this.id = id;
		
		Constructor<? extends FileArtifact> ctr;
		
		try {
			ctr = c.getConstructor(String.class, File.class);
			for (String i : fileNames){
				this.add(ctr.newInstance(null, new File(baseDir, i)));
			}
		} catch (NoSuchMethodException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		} catch (SecurityException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		} catch (InstantiationException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		} catch (IllegalAccessException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		} catch (InvocationTargetException e) {
			throw new RuntimeDroolsException("Can't create FileArtifactList with parametrized class " + c.toString(), e);
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	protected File materialize(File tmpDir){
		java.io.File list = new java.io.File(tmpDir, java.util.UUID.randomUUID().toString());
		java.io.FileWriter fwr;
		try {
			fwr = new java.io.FileWriter(list, false);
			for (FileArtifact i : this){
				fwr.write(i.getAbsolutePath());
				fwr.write('\n');
			}
			fwr.close();
		} catch (IOException e) {
			throw new RuntimeDroolsException("Can't materialize filelist", e);
		}
		
		return list;
	}
}
