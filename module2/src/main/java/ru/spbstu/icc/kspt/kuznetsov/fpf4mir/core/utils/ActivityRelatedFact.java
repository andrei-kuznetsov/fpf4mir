package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public interface ActivityRelatedFact extends FPFCloneable {
	public Activity getActivity();
	public void setActivity(Activity activity);
}
