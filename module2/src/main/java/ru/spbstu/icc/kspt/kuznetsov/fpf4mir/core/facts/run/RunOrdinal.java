package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class RunOrdinal extends OrdinalArgument {

	public RunOrdinal(Activity activity, int order, String value) {
		super(activity, order, value);
	}

	public RunOrdinal(Activity activity, String value) {
		super(activity, value);
	}

	@Override
	public String toString() {
		return "RunOrdinal [toString()=" + super.toString() + "]";
	}
}
