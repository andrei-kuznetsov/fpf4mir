package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;

public class ReqDataset2FileArtifactList extends RequestFactBase implements RequestFact{

	public ReqDataset2FileArtifactList(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqDataset2FileArtifactList(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	@Override
	public String toString() {
		return "ReqDataset2FileArtifactList []";
	}

}
