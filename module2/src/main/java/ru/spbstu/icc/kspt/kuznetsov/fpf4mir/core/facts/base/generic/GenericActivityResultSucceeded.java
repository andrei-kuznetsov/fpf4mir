package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityResultSucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.base.ActivityRelatedFactBase;

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
