package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public interface ArtifactAlias {

	public RequestFact getRequest();
	public void setRequest(RequestFact request);

	public RequestStatus getRstatus();
	public void setRstatus(RequestStatus request);
	
	public String getName();
	public void setName(String name);
	
	/*
	public Artifact getArtifact();
	public void setArtifact(Artifact artifact);
	*/
	
	public ArtifactAlias clone(RequestFact newRequest);
	public ArtifactAlias clone(RequestFact newRequest, String newName);
	
	/*
	public Artifact cloneArtifact(Activity newActivity);
	public Artifact cloneArtifact(Activity newActivity, String newName);
	*/
	
}
