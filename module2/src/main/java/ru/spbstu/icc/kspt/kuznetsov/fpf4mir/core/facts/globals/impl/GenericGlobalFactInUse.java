package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.impl;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.GlobalFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.globals.GlobalFactInUse;

public final class GenericGlobalFactInUse extends GlobalFactInUseBase<GlobalFact> implements GlobalFactInUse<GlobalFact>{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2137199848644969767L;

	public GenericGlobalFactInUse() {
		super();
	}

	public GenericGlobalFactInUse(Activity activity, GlobalFact fact) {
		super(activity, fact);
	}

}
