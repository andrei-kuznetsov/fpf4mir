package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.KeyValueArgument;

public class RunOption extends KeyValueArgument{

	public RunOption(Run activity, String key, String value) {
		super(activity, key, value);
	}

	@Override
	public String toString() {
		return "RunOption [toString()=" + super.toString() + "]";
	}

}
