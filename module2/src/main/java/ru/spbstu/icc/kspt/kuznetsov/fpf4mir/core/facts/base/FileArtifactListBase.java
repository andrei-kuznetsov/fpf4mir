package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.FileArtifactList;

public class FileArtifactListBase extends ActivityRelatedFactBase implements FileArtifactList{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3493200466299237227L;

	private final ArrayList<FileArtifact> list; // we don't extend list because we want to have more control over equals and hash methods
	private String name;
	
	
	public FileArtifactListBase() {
		list = new ArrayList<FileArtifact>();
	}
	
	public FileArtifactListBase(Activity activity, String listName, File baseDir, String fileNames[]) {
		this(activity, listName, baseDir, fileNames, FileArtifact.class);
	}
	
	protected FileArtifactListBase(Activity activity, FileArtifactList list) {
		super(activity);
		this.list = new ArrayList<FileArtifact>(list.list());
	}
	
	public FileArtifactListBase(Activity activity, String listName, File baseDir, String[] fileNames, Class<? extends FileArtifact> c) {
		super(activity);
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

	public FileArtifactListBase reset(Activity activity, FileArtifactList list) {
		super.reset(activity);
		this.name = list.getName();
		this.list.clear();
		this.list.addAll(list.list());
		return this;
	}
	
	public FileArtifactListBase reset(Activity activity, List<? extends FileArtifact> list){
		super.reset(activity);
		this.clear();
		this.list.addAll(list);
		this.name = "default";
		return this;
	}

}
