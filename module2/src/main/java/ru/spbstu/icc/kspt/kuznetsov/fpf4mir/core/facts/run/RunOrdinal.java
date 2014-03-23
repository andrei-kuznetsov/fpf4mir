package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class RunOrdinal extends OrdinalArgument {

	public RunOrdinal(Run activity, int order, String value) {
		super(activity, order, value);
	}

	public RunOrdinal(Run activity, String value) {
		super(activity, value);
	}

	@Override
	public String toString() {
		return "RunOrdinal [toString()=" + super.toString() + "]";
	}
}
