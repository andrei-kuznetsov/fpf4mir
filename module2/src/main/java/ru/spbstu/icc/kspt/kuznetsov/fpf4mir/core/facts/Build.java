package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class Build extends Activity {

	public Build(int number, Date date, ReqNewActivity request) {
		super(R.id.BuildActivity, number, date, request);
	}

	@Override
	public String toString() {
		return "Build [toString()=" + super.toString() + "]";
	}
	
}
