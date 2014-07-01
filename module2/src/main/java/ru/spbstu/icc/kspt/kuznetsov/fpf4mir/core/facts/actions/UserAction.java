package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.FactWithRefId;



public interface UserAction extends ActionFact, FactWithRefId {
	public String getDescription();
	public void setDescription(String description);
}
