package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public interface ActionStatus {

	public abstract boolean isSucceeded();

	public abstract Activity getActivity();

}