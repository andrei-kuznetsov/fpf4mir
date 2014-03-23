package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.ActivityError;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class RunError extends RunFactImpl implements ActivityError{
	private String message;
	private RunErrorIds errorId;
	
	public RunError(RunErrorIds errorId, Run run, String message) {
		super(run);
		this.message = message;
		this.errorId = errorId;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "BuildError [message=" + message + ", errorId=" + errorId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((errorId == null) ? 0 : errorId.hashCode());
		result = prime * result + ((message == null) ? 0 : message.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof RunError))
			return false;
		RunError other = (RunError) obj;
		if (errorId != other.errorId)
			return false;
		if (message == null) {
			if (other.message != null)
				return false;
		} else if (!message.equals(other.message))
			return false;
		return true;
	}

	public RunErrorIds getErrorId() {
		return errorId;
	}

	public void setErrorId(RunErrorIds errorId) {
		this.errorId = errorId;
	}
}
