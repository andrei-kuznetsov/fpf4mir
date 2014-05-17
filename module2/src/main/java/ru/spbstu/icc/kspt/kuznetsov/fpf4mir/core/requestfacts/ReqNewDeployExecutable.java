package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class ReqNewDeployExecutable extends RequestFactBase implements ReqNewActivity {
private String deploymentName;

	
	public ReqNewDeployExecutable(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqNewDeployExecutable(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	@Override
	public String toString() {
		return "ReqNewExecutableDeployment [deploymentName=" + deploymentName
				+ "]";
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	@Override
	public Activity newActivityInstance() {
		return null;
	}

	@Override
	public String getActivityName() {
		// TODO Auto-generated method stub
		return null;
	}
}
