package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl;

import java.io.Serializable;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.ActionStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityRelatedFactBase;

public abstract class ActionStatusBase<T extends ActivityRelatedFact> extends ActivityRelatedFactBase implements ActionStatus, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -3231409981740220661L;
	private Action action;
	private T parameter;
	
	public ActionStatusBase() {
		super();
	}

	public ActionStatusBase(Activity activity) {
		super(activity);
	}

	public ActionStatusBase(Activity activity, T parameter) {
		super(activity);
		this.parameter = parameter;
	}
	
	public Action getAction() {
		return action;
	}

	public void setAction(Action action) {
		this.action = action;
	}

	@Override
	public T getParameter() {
		return parameter;
	}
	
	public void setParameter(T parameter) {
		this.parameter = parameter;
	}
}
