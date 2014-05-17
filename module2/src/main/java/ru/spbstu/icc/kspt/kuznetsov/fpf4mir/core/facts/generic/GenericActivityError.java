package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityError;

public class GenericActivityError implements ActivityError{
	private GenericActivity activity;

	public GenericActivityError(GenericActivity activity) {
		super();
		this.activity = activity;
	}

	public GenericActivity getActivity() {
		return activity;
	}

	public void setActivity(GenericActivity activity) {
		this.activity = activity;
	}
}
