package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;

public interface GlobalFactInUse<U extends GlobalFact> extends ActivityRelatedFact{
	public U getFact();
}
