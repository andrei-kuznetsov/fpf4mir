package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public interface ArtifactAlias {

	public RequestFact getRequest();
	public void setRequest(RequestFact request);
	
	public String getName();
	public void setName(String name);
}
