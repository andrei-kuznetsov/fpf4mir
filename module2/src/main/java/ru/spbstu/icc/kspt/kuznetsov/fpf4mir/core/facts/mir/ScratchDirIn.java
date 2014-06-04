package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqRun;

public class ScratchDirIn {
	private String datasetId;
	private ReqRun request;
	
	public ScratchDirIn(String datasetId, ReqRun request) {
		this.datasetId = datasetId;
		this.request = request;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public ReqRun getRequest() {
		return request;
	}

	public void setRequest(ReqRun request) {
		this.request = request;
	}

	@Override
	public String toString() {
		return "ScratchDirIn [datasetId=" + datasetId + "]";
	}
}
