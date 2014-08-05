package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.GlobalFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface Feature extends GlobalFact, FactWithName, FPFCloneable {
	@Override public String getName();
	public String getVersion();
}
