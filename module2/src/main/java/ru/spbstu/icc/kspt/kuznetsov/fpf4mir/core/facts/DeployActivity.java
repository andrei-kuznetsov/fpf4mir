package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class DeployActivity extends Activity {

	public DeployActivity(int number, Date date, ReqNewActivity request) {
		super(R.id.DeployActivity, number, date, request);
	}

}
