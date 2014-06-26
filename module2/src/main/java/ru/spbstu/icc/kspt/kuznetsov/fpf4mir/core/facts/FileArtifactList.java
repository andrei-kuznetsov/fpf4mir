package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Iterator;
import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface FileArtifactList extends FPFCloneable, FactWithName, ActivityRelatedFact, Iterable<FileArtifact> {
		
	@Override public String getName();
	@Override public void setName(String name);


	@Override public Iterator<FileArtifact> iterator();
	
	public FileArtifact get(int index);
	public int size();
	public List<FileArtifact> list();
}
