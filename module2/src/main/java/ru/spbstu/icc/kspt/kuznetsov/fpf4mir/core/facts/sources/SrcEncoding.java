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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((encoding == null) ? 0 : encoding.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof SrcEncoding))
			return false;
		SrcEncoding other = (SrcEncoding) obj;
		if (encoding == null) {
			if (other.encoding != null)
				return false;
		} else if (!encoding.equals(other.encoding))
			return false;
		return true;
	}
}
