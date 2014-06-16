package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface Feature extends FactWithName {
	@Override public String getName();
	public String getVersion();
}
