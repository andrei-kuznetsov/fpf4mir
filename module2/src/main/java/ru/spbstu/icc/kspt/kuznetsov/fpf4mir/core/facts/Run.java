package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class Run extends Activity {

	public Run(String id, int number, Date date, ReqNewActivity request) {
		super(id, number, date, request);
	}

	public Run(Run run) {
		super(run);
	}

	@Override
	public String toString() {
		return "Run [toString()=" + super.toString() + "]";
	}

}
