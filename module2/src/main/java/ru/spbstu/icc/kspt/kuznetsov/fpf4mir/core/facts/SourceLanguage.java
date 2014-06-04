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
	public String toString() {
		return "SourceLanguage [sourceLanguage=" + sourceLanguage + "]";
	}
	
}
