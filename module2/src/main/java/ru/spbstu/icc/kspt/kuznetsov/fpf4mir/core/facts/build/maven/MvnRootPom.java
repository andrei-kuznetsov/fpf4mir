package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public class MvnRootPom implements FileArtifactAlias {
	private FileArtifact file;
	
	public MvnRootPom(FileArtifact artifact) {
		this.file = artifact; 
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven.FileArtifactAlias#getFile()
	 */
	@Override
	public FileArtifact getFile() {
		return file;
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven.FileArtifactAlias#setFile(ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact)
	 */
	@Override
	public void setFile(FileArtifact file) {
		this.file = file;
	}

	@Override
	public RequestFact getRequest() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRequest(RequestFact request) {
		// TODO Auto-generated method stub
		
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
