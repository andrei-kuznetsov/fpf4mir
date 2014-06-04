package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqRun;

public class RunDatasetIn {
	private ReqRun request;
	private String datasetId;
	

	public RunDatasetIn(ReqRun request, String datasetId) {
		this.datasetId = datasetId;
		this.request = request;
	}

	public ReqRun getRequest() {
		return request;
	}

	public void setRequest(ReqRun request) {
		this.request = request;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	@Override
	public String toString() {
		return "RunDataIn [request=" + request + ", datasetId=" + datasetId
				+ "]";
	}
	
}
