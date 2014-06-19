package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ReqNewActivityBase;

public class ReqDeployExecutable extends ReqNewActivityBase implements ReqNewActivity {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1457321945538143431L;
	
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
				+ ", getRefId()=" + getRefId() + "]";
	}

	public String getDeploymentName() {
		return deploymentName;
	}

	public void setDeploymentName(String deploymentName) {
		this.deploymentName = deploymentName;
	}
}
