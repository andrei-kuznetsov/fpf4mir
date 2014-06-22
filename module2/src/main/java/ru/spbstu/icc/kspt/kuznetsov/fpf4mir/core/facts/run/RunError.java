package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityErrorBase;

public class RunError extends ActivityErrorBase implements ActivityError{

	public RunError() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RunError(Activity activity, String message) {
		super(activity, message);
		// TODO Auto-generated constructor stub
	}
	
}
