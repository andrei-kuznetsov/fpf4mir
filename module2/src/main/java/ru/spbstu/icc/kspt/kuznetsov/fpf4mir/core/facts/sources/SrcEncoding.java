package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources;

public class SrcEncoding extends SrcFactBase{
	private String encoding;

	public SrcEncoding(String srcEncoding) {
		this.encoding = srcEncoding;
	}

	public String getEncoding() {
		return encoding;
	}

	public void setEncoding(String srcEncoding) {
		this.encoding = srcEncoding;
	}

	@Override
	public String toString() {
		return "SrcEncoding [srcEncoding=" + encoding + "]";
	}

}
