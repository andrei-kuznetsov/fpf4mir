package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import java.util.List;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.BuildCommand;

public class RequestSubstatusBuildProposal extends RequestSubstatusBase implements RequestSubstatus{
	private List<BuildCommand> buildCommands;

	public RequestSubstatusBuildProposal(RequestFact mainStatus, List<BuildCommand> buildCommands) {
		super(mainStatus);
		this.buildCommands = buildCommands;
	}

	public List<BuildCommand> getBuildCommands() {
		return buildCommands;
	}

	public void setBuildCommands(List<BuildCommand> buildCommands) {
		this.buildCommands = buildCommands;
	}
	
}
