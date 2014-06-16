package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.features;


public class MavenFeature extends FeatureBase implements Feature{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5437763028339790625L;
	
	private String cmdName;

	public MavenFeature(){
		super("maven");
	}
	
	public String getCmdName() {
		return cmdName;
	}

	public void setCmdName(String cmdName) {
		this.cmdName = cmdName;
	}
}
