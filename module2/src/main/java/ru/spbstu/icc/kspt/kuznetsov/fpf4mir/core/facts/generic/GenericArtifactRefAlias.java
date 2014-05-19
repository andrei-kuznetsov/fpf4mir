package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ArtifactRefAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;

public final class GenericArtifactRefAlias extends ArtifactAliasBase implements ArtifactRefAlias, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -2799751610601964675L;
	
	private ArtifactRef artifactRef;

	public void reset(RequestFact request, String name, ArtifactRef artifactRef) {
		super.reset(request, name);
		this.artifactRef = artifactRef;
	}

	public void reset(RequestFact request, ArtifactRef artifactRef) {
		this.reset(request, artifactRef.getName(), artifactRef);
	}
	
	public void reset(RequestFact request, ArtifactAlias artifactAlias, ArtifactRef artifactRef) {
		super.reset(request, artifactAlias);
		this.artifactRef = artifactRef;
	}

	public ArtifactRef getArtifactRef() {
		return artifactRef;
	}

	public void setArtifactRef(ArtifactRef artifactRef) {
		this.artifactRef = artifactRef;
	}
	
	public ArtifactRef cloneArtifact(Activity newActivity) {
		ArtifactRef copy = org.apache.commons.lang3.SerializationUtils.clone(this.getArtifactRef());
		copy.setActivity(newActivity);
		return copy;
	}

	public ArtifactRef cloneArtifact(Activity newActivity, String newName) {
		ArtifactRef copy = org.apache.commons.lang3.SerializationUtils.clone(this.getArtifactRef());
		copy.setActivity(newActivity);
		copy.setName(newName);
		return copy;
	}
}
