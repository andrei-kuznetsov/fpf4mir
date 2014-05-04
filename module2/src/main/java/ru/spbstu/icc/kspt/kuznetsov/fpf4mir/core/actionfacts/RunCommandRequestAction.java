package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecStatus;

public class RunCommandRequestAction extends ActionFactBase implements ActionFact {
	private ExecStatus status;

	public RunCommandRequestAction(Activity activity, ExecStatus status) {
		super(activity);
		this.status = status;
	}

	@Override
	public String toString() {
		return "RunCommandRequestAction [status=" + status + ", getActivity()="
				+ getActivity() + "]";
	}

	public ExecStatus getStatus() {
		return status;
	}

	public void setStatus(ExecStatus status) {
		this.status = status;
	}
}
