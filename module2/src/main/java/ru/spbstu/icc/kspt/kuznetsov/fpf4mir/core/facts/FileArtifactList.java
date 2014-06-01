package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class FileArtifactList extends ArrayList<FileArtifact> implements FPFCloneable, FactWithName, ActivityRelatedFact {
	private static final long serialVersionUID = 1L;

	private Activity activity;
	private String name;
	
	public FileArtifactList() {
	}
	
	public FileArtifactList(Activity activity, String listName, File baseDir, String fileNames[]) {
		this(activity, listName, baseDir, fileNames, FileArtifact.class);
	}
	
	protected FileArtifactList(Activity activity, FileArtifactList list) {
		super(list);
		this.activity = activity;
	}
	
	public FileArtifactList(Activity activity, String listName, File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		this.activity = activity;
		this.name = listName;
		
		Constructor<? extends FileArtifact> ctr;
		
		try {
			ctr = c.getConstructor(Activity.class, String.class, String.class);
			final String baseDirName = baseDir.getAbsolutePath();
			for (String i : fileNames){
				this.add(ctr.newInstance(activity, baseDirName, i));
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
		String s = super.toString();
		return s.replace(", FileArtifact", "\n FileArtifact");
	}
}
