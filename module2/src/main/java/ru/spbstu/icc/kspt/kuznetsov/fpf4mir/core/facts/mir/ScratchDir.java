package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class ScratchDir extends FolderArtifact {
	/**
	 * 
	 */
	private static final long serialVersionUID = -170551189121306734L;
	private String datasetId;
	
	
	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}

}
