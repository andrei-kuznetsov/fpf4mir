package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class GenericActivity extends Activity {
	
	public GenericActivity(Activity activity) {
		super(activity);
	}

	public GenericActivity(String activityName, int number, Date date,
			ReqNewActivity request) {
		super(activityName, number, date, request);
	}
}
