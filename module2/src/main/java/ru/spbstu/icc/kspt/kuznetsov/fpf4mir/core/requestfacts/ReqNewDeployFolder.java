package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DeployActivity;

public class ReqNewDeployFolder extends RequestFactBase implements ReqNewActivity {
	private String deploymentName;

	
	public ReqNewDeployFolder(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqNewDeployFolder(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	@Override
	public String toString() {
		return "ReqNewDeployment [deploymentName="
				+ deploymentName + "]";
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	@Override
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new DeployActivity(deploymentName, (int)date.getTime(), date, this);
	}

	@Override
	public String getActivityName() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
