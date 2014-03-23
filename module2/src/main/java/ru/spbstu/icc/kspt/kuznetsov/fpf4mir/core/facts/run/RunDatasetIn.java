package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewRun;

public class RunDatasetIn {
	private ReqNewRun request;
	private String datasetId;
	

	public RunDatasetIn(ReqNewRun request, String datasetId) {
		this.datasetId = datasetId;
		this.request = request;
	}

	public ReqNewRun getRequest() {
		return request;
	}

	public void setRequest(ReqNewRun request) {
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
