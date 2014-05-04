package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.deploy;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DeployActivity;

public class DeployError extends DeployFactBase implements ActivityError{
	private String message;
	
	public DeployError(DeployActivity deploy, String message) {
		super(deploy);
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
