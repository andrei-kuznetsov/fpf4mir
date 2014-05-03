package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources.SrcEncoding;

public class BuildSrcEncoding extends BuildFactBase {
	private SrcEncoding srcEncoding;

	public BuildSrcEncoding(Build build) {
		super(build);
	}
	
	public BuildSrcEncoding(Build build, SrcEncoding srcEncoding) {
		super(build);
		this.srcEncoding = srcEncoding;
	}

	public SrcEncoding getSrcEncoding() {
		return srcEncoding;
	}

	public void setSrcEncoding(SrcEncoding srcEncoding) {
		this.srcEncoding = srcEncoding;
	}
}
