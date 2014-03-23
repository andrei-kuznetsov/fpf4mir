package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.build.maven;

import org.drools.RuntimeDroolsException;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Build;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.cmd.OrdinalArgument;

public class MvnOption_SrcEncoding extends OrdinalArgument implements MvnOption {
	private final static String MVN_OPTION_KEY =  "-Dproject.build.sourceEncoding=";
	
	public MvnOption_SrcEncoding(Build build, String srcEncoding) {
		super(build);
		setSrcEncoding(srcEncoding);
	}

	public String getSrcEncoding() {
		final String enc = super.getValue();
		if (enc.startsWith(MVN_OPTION_KEY)){
			return enc.substring(MVN_OPTION_KEY.length());
		} else {
			throw new RuntimeDroolsException("Can't get encoding value from string '" + enc + "'");
		}
	}

	public void setSrcEncoding(String srcEncoding) {
		this.setValue(MVN_OPTION_KEY + srcEncoding);
	}
	
}
