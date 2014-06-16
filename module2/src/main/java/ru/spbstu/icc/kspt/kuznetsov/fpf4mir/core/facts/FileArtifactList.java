package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public class FileArtifactList implements FPFCloneable, FactWithName, ActivityRelatedFact, Serializable, Iterable<FileArtifact> {
	private static final long serialVersionUID = 1L;
	private final ArrayList<FileArtifact> list; // we don't extend list because we want to have more control over equals and hash methods
	private Activity activity;
	private String name;
	
	public FileArtifactList() {
		list = new ArrayList<FileArtifact>();
	}
	
	public FileArtifactList(Activity activity, String listName, File baseDir, String fileNames[]) {
		this(activity, listName, baseDir, fileNames, FileArtifact.class);
	}
	
	protected FileArtifactList(Activity activity, FileArtifactList list) {
		this.list = new ArrayList<FileArtifact>(list.list);
		this.activity = activity;
	}
	
	public FileArtifactList(Activity activity, String listName, File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		this.activity = activity;
		this.name = listName;
		this.list = new ArrayList<FileArtifact>(fileNames.length + 1);
		Constructor<? extends FileArtifact> ctr;
		
		try {
			ctr = c.getConstructor(Activity.class, String.class, String.class);
			final String baseDirName = baseDir.getAbsolutePath();
			for (String i : fileNames){
				this.list.add(ctr.newInstance(activity, baseDirName, i));
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
			for (FileArtifact i : this.list){
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
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
	protected void clear(){
		list.clear();
	}
	
	protected void addAll(Collection<? extends FileArtifact> c){
		list.addAll(c);
	}

	@Override
	public Iterator<FileArtifact> iterator() {
		return list.iterator();
	}
	
	public FileArtifact get(int index){
		return list.get(index);
	}
	
	public int size(){
		return list.size();
	}
	
	public List<FileArtifact> list(){
		return list;
	}
}
