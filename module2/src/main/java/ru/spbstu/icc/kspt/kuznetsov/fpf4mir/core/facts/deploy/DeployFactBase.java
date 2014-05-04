package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.deploy;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DeployActivity;

public class DeployFactBase {
	private DeployActivity deploy;

	public DeployFactBase(DeployActivity deploy) {
		super();
		this.deploy = deploy;
	}

	public DeployActivity getDeploy() {
		return deploy;
	}

	public void setDeploy(DeployActivity deploy) {
		this.deploy = deploy;
	}
	
	public Activity getActivity(){
		return getDeploy();
	}
}
