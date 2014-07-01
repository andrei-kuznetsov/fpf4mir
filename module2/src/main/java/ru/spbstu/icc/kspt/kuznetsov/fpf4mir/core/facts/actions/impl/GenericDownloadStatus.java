package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;

public class GenericDownloadStatus extends DownloadStatusBase implements DownloadStatus{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2211376468288675938L;

	public GenericDownloadStatus(Activity activity, ArtifactRef artifactRef,
			int status) {
		super(activity, artifactRef, status);
	}

}
