package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;

public class BuildSucceeded extends BuildFactBase implements ActivitySucceded {

	public BuildSucceeded(BuildActivity build) {
		super(build);
	}

}
