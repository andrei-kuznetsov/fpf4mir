package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceeded;

public class GenericActivitySucceeded extends ActivityStatusBase implements ActivitySucceeded {

	public GenericActivitySucceeded() {
		super();
	}

	public GenericActivitySucceeded(Activity activity) {
		super(activity);
	}


}
