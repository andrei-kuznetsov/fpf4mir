package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityResult;

public interface ActivityResultRelatedFact extends FPFCloneable{
	public ActivityResult getAresult();
	public void setAresult(ActivityResult astatus);
}
