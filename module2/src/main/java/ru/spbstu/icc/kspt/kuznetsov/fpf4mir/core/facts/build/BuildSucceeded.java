package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;

public class BuildSucceeded extends BuildFactBase implements ActivitySucceded {

	public BuildSucceeded(Build build) {
		super(build);
	}

}
