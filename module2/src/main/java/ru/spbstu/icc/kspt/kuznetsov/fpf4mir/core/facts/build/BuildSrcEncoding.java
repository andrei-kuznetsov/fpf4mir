package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.sources.SrcEncoding;

public class BuildSrcEncoding extends BuildFactBase {
	private SrcEncoding srcEncoding;

	public BuildSrcEncoding(BuildActivity build) {
		super(build);
	}
	
	public BuildSrcEncoding(BuildActivity build, SrcEncoding srcEncoding) {
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
