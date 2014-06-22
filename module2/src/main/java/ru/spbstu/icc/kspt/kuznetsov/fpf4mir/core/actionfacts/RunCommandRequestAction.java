package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;

public class RunCommandRequestAction extends ActionFactBase implements ActionFact {
	/**
	 * 
	 */
	private static final long serialVersionUID = 9163064851765084941L;
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
