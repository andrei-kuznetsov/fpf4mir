package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;

/**
 * Result of active phase of activity
 * @author andrei
 *
 */
public interface ActivityResult extends ActivityRelatedFact{
	public String getMessage();
	public void setMessage(String message);
}
