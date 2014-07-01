package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.aliases;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface Reference<U> extends ActivityRelatedFact, FactWithName {
	public U getRefObject();
	public void setRefObject(U refObject);
}
