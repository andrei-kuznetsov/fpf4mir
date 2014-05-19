package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class ReqDeployExecutable extends RequestFactBase implements ReqNewActivity {
	private String deploymentName;

	
	public ReqDeployExecutable(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqDeployExecutable(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	@Override
	public String toString() {
		return "ReqDeployExecutable [deploymentName=" + deploymentName
				+ "]";
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	@Override
	public String getActivityName() {
		// TODO Auto-generated method stub
		return null;
	}
}
