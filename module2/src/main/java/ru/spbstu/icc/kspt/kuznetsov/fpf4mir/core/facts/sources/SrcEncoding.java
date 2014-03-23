package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources;

public class SrcEncoding {
	private String srcEncoding;

	public SrcEncoding(String srcEncoding) {
		this.srcEncoding = srcEncoding;
	}

	public String getSrcEncoding() {
		return srcEncoding;
	}

	public void setSrcEncoding(String srcEncoding) {
		this.srcEncoding = srcEncoding;
	}

	@Override
	public String toString() {
		return "SrcEncoding [srcEncoding=" + srcEncoding + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((srcEncoding == null) ? 0 : srcEncoding.hashCode());
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
		if (srcEncoding == null) {
			if (other.srcEncoding != null)
				return false;
		} else if (!srcEncoding.equals(other.srcEncoding))
			return false;
		return true;
	}
}
