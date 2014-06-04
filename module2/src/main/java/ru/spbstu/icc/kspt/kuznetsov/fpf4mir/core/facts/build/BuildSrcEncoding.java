package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources.SrcEncoding;

public class BuildSrcEncoding extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -524301176610860172L;
	private SrcEncoding srcEncoding;

	public SrcEncoding getSrcEncoding() {
		return srcEncoding;
	}

	public void setSrcEncoding(SrcEncoding srcEncoding) {
		this.srcEncoding = srcEncoding;
	}
}
