package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class DetectEncodingAction extends ActionFactBase implements ActionFact {
	public DetectEncodingAction(Activity activity) {
		super(activity);
	}

	@Override
	public boolean equals(Object obj) {
		return (obj instanceof DetectEncodingAction);
	}
	
	@Override
	public int hashCode() {
		return 346;
	}
}
