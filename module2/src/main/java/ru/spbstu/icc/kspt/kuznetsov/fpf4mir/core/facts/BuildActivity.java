/*
 *  We renamed class Build to BuildActivity because we had conflict of
 *  class name "ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build" with
 *  package name "ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build".
 *  It's not a problem for Java, but a problem for MVEL compiler used by 
 *  Drools 5.5.0.Final
 *  
 *  This problem was observed on Windows OS. 
 */

package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class BuildActivity extends Activity {

	public BuildActivity(int number, Date date, ReqNewActivity request) {
		super(R.id.BuildActivity, number, date, request);
	}
	
}
