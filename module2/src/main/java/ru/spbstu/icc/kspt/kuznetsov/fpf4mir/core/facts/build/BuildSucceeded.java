package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceeded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;

public class BuildSucceeded extends BuildFactBase implements ActivitySucceeded {

	public BuildSucceeded(BuildActivity build) {
		super(build);
	}

}
