package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.activities;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class DeployExecutableActivity extends Activity {

	public DeployExecutableActivity(Activity activity) {
		super(activity);
	}

	public DeployExecutableActivity(int number, Date date,
			ReqNewActivity request) {
		super(R.id.DeployExecutableActivity, number, date, request);
	}

}
