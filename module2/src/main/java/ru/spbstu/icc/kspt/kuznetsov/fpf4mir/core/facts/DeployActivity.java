package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class DeployActivity extends Activity {
	private String deploymentName;
	
	public DeployActivity(String deploymentName, int number, Date date, ReqNewActivity request) {
		super(R.id.DeployActivity, number, date, request);
		this.deploymentName = deploymentName;
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}

	
}
