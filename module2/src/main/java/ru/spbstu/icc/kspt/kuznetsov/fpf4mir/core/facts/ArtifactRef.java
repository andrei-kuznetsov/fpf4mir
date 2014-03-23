package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.net.URI;

public class ArtifactRef {
	private URI ref;
	private String id;
	
	public ArtifactRef(String id, URI ref) {
		this.id = id;
		this.ref = ref;
	}

	public URI getRef() {
		return ref;
	}

	public void setRef(URI ref) {
		this.ref = ref;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
