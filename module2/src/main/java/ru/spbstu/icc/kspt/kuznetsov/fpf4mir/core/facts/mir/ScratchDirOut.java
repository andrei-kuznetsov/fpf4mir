package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class ScratchDirOut extends FolderArtifact{
	/**
	 * 
	 */
	private static final long serialVersionUID = 2066453968850630317L;
	private String datasetId;

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}
	
}
