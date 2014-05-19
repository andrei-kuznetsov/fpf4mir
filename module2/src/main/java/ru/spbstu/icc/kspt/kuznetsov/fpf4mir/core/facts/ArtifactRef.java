package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.io.Serializable;
import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFactWithName;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.CloneUtils;

public class ArtifactRef implements ActivityRelatedFactWithName, Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2243838108487140964L;
	
	private URI ref;
	private Activity activity;
	private String name;
	
	public ArtifactRef(Activity activity, URI ref) {
		this.activity = activity;
		this.ref = ref;
	}

	public ArtifactRef(Activity activity, ArtifactRef ref) {
		this(activity, ref.getRef());
	}
	
	public ArtifactRef(Activity activity, ArtifactRefAlias ref) {
		this(activity, ref.getArtifactRef());
	}

	public URI getRef() {
		return ref;
	}

	public void setRef(URI ref) {
		this.ref = ref;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public ArtifactRef clone(Activity newActivity) {
		return CloneUtils.cloneActivityRelatedFact(this, newActivity);
	}

	public ArtifactRef clone(Activity newActivity, String newName) {
		return CloneUtils.cloneActivityRelatedFactWithName(this, newActivity, newName);
	}
	
}
