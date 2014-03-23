package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewRun;

public class ScratchDirIn {
	private String datasetId;
	private ReqNewRun request;
	
	public ScratchDirIn(String datasetId, ReqNewRun request) {
		this.datasetId = datasetId;
		this.request = request;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

	public ReqNewRun getRequest() {
		return request;
	}

	public void setRequest(ReqNewRun request) {
		this.request = request;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((datasetId == null) ? 0 : datasetId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof ScratchDirIn))
			return false;
		ScratchDirIn other = (ScratchDirIn) obj;
		if (datasetId == null) {
			if (other.datasetId != null)
				return false;
		} else if (!datasetId.equals(other.datasetId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScratchDirIn [datasetId=" + datasetId + "]";
	}
}
