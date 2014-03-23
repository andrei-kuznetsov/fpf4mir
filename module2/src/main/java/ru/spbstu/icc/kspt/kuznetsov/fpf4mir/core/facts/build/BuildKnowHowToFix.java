package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;


public class BuildKnowHowToFix extends BuildFact{
	private BuildError error;
	
	public BuildKnowHowToFix(BuildError error) {
		super(error.getBuild());
		this.error = error;
	}

	public BuildError getError() {
		return error;
	}

	public void setErrorId(BuildError error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "KnowHowToFix [errorId=" + error + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((error == null) ? 0 : error.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof BuildKnowHowToFix))
			return false;
		BuildKnowHowToFix other = (BuildKnowHowToFix) obj;
		if (error != other.error)
			return false;
		return true;
	}
}
