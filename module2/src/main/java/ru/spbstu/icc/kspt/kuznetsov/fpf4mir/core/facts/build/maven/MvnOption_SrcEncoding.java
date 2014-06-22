package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.BuildSrcEncoding;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class MvnOption_SrcEncoding extends OrdinalArgument implements MvnOption {
	private final static String MVN_OPTION_KEY =  "-Dproject.build.sourceEncoding=";
	
	private BuildSrcEncoding buildSrcEncoding;
	
	public MvnOption_SrcEncoding(Activity build, BuildSrcEncoding srcEncoding) {
		super(build);
		setSrcEncoding(srcEncoding);
	}

	public BuildSrcEncoding getBuildSrcEncoding() {
		return buildSrcEncoding;
	}

	public void setSrcEncoding(BuildSrcEncoding buildSrcEncoding) {
		this.buildSrcEncoding = buildSrcEncoding;
		this.setValue(MVN_OPTION_KEY + buildSrcEncoding.getSrcEncoding().getEncoding());
	}
	
}
