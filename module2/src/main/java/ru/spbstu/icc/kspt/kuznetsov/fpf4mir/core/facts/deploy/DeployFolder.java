package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.deploy;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class DeployFolder implements FolderArtifactAlias{
	private RequestFact request;
	private FolderArtifact folder;

	public DeployFolder(RequestFact request, FolderArtifact folder) {
		super();
		this.request = request;
		this.folder = folder;
	}

	public FolderArtifact getFolder() {
		return folder;
	}

	public void setFolder(FolderArtifact folder) {
		this.folder = folder;
	}

	public RequestFact getRequest() {
		return request;
	}

	public void setRequest(RequestFact request) {
		this.request = request;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		
	}
	
}
