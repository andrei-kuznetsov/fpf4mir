package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.net.URI;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public final class GenericDownloadAction extends DownloadActionBase implements DownloadAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3858230385946955352L;

	public GenericDownloadAction(Activity activity, URI uri) {
		super(activity, uri);
	}

	public GenericDownloadAction(Activity activity) {
		super(activity);
	}

}
