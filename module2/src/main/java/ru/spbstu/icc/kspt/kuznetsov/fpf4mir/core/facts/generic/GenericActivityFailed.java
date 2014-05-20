package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityFailed;

public class GenericActivityFailed extends ActivityStatusBase implements ActivityFailed{

	public GenericActivityFailed() {
		super();
	}

	public GenericActivityFailed(Activity activity) {
		super(activity);
	}

}
