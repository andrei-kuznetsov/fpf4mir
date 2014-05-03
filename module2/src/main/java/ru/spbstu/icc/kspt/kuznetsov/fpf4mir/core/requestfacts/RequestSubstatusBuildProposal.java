package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildCommand;

public class RequestSubstatusBuildProposal extends RequestSubstatusBase implements RequestSubstatus{
	private List<BuildCommand> buildCommands;

	public RequestSubstatusBuildProposal(List<BuildCommand> buildCommands) {
		super();
		this.buildCommands = buildCommands;
	}

	public List<BuildCommand> getBuildCommands() {
		return buildCommands;
	}

	public void setBuildCommands(List<BuildCommand> buildCommands) {
		this.buildCommands = buildCommands;
	}
	
}
