package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public interface ActivityRelatedFact extends Serializable {
	public Activity getActivity();
	public void setActivity(Activity activity);
}
