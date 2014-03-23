package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ExecStatus;

public class RunCommandRequestAction implements ActionFact {
	private ExecStatus status;

	public RunCommandRequestAction(ExecStatus status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "RunCommandRequestAction [build=" + status + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof RunCommandRequestAction))
			return false;
		RunCommandRequestAction other = (RunCommandRequestAction) obj;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		return true;
	}

	public ExecStatus getStatus() {
		return status;
	}

	public void setStatus(ExecStatus status) {
		this.status = status;
	}
}
