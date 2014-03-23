package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class RunKnowHowToFix extends RunFactImpl{
	private RunErrorIds errorId;

	public RunKnowHowToFix(Run run, RunErrorIds errorId) {
		super(run);
		this.errorId = errorId;
	}

	public RunErrorIds getErrorId() {
		return errorId;
	}

	public void setErrorId(RunErrorIds errorId) {
		this.errorId = errorId;
	}

	@Override
	public String toString() {
		return "KnowHowToFix [errorId=" + errorId + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((errorId == null) ? 0 : errorId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (!(obj instanceof RunKnowHowToFix))
			return false;
		RunKnowHowToFix other = (RunKnowHowToFix) obj;
		if (errorId != other.errorId)
			return false;
		return true;
	}
}
