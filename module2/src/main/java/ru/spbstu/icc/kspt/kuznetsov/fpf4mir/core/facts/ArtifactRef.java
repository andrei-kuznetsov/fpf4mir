package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.net.URI;

public class ArtifactRef {
	private URI ref;
	private Activity activity;
	
	public ArtifactRef(Activity activity, URI ref) {
		this.activity = activity;
		this.ref = ref;
	}

	public ArtifactRef(Activity activity, ArtifactRef ref) {
		this(activity, ref.getRef());
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
	
}
