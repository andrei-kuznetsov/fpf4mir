package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.deploy;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivitySucceded;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DeployActivity;

public class DeploySucceeded extends DeployFactBase implements ActivitySucceded {

	public DeploySucceeded(DeployActivity deploy) {
		super(deploy);
	}


}
