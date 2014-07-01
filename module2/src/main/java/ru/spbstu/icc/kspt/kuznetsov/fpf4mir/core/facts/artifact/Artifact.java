package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact;

import java.io.File;
import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface Artifact extends ActivityRelatedFact, Serializable, FPFCloneable, FactWithName {

	@Override public Activity getActivity();
	@Override public void setActivity(Activity activity);

	@Override public String getName();
	@Override public void setName(String name);
	
	public boolean isDirectory();
	
	public String getFileName();
	public void setFileName(String fileName);

	public String getBaseDir();
	public void setBaseDir(String baseDir);

	public String getAbsolutePath();
	
	public File _getFile();

}
