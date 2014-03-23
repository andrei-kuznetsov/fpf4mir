package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts;

public class SourceLanguage {
	public enum SOURCE_LANGUAGES {
		JAVA,
		PYTHON,
		C_CPP,
		OTHER
	}
	
	private SOURCE_LANGUAGES sourceLanguage = SOURCE_LANGUAGES.OTHER;

	public SourceLanguage(SOURCE_LANGUAGES sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	public SourceLanguage() {
	}

	public SOURCE_LANGUAGES getSourceLanguage() {
		return sourceLanguage;
	}

	public void setSourceLanguage(SOURCE_LANGUAGES sourceLanguage) {
		this.sourceLanguage = sourceLanguage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sourceLanguage == null) ? 0 : sourceLanguage.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SourceLanguage other = (SourceLanguage) obj;
		if (sourceLanguage != other.sourceLanguage)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SourceLanguage [sourceLanguage=" + sourceLanguage + "]";
	}
	
}
