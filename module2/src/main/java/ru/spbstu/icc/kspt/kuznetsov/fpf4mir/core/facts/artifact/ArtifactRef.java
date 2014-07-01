package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact;

import java.io.Serializable;
import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface ArtifactRef extends ActivityRelatedFact, FactWithName, FPFCloneable, Serializable {

	@Override public Activity getActivity();
	@Override public void setActivity(Activity activity);

	@Override public String getName();
	@Override public void setName(String name);
	
	public URI getRef();
	public void setRef(URI ref);
}
