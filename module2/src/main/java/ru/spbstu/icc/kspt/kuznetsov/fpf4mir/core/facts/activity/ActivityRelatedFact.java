package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;

public interface ActivityRelatedFact extends FPFCloneable {
	public Activity getActivity();
	public void setActivity(Activity activity);
}
