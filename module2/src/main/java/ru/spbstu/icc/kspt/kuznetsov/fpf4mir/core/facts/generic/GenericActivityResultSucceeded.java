package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityResultSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class GenericActivityResultSucceeded extends ActivityRelatedFactBase implements ActivityResultSucceeded {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3818192422117613656L;

	public GenericActivityResultSucceeded() {
		super();
	}

	public GenericActivityResultSucceeded(Activity activity) {
		super(activity);
	}

}
