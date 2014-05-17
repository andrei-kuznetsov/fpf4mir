package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.activities;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class GuessRunCommand extends Activity {

	public GuessRunCommand(int number, Date date, ReqNewActivity request) {
		super(R.id.GuessRunCommandActivity, number, date, request);
	}

}
