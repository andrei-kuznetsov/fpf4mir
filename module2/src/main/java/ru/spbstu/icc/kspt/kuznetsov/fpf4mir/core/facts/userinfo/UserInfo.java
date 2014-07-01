package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.userinfo;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FPFCloneable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithName;

public interface UserInfo<U> extends ActivityRelatedFact, FactWithName, FPFCloneable {
	public U getMessage();
	public Date getDate();
}
