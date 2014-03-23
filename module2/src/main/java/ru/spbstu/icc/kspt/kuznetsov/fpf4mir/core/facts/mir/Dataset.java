package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class Dataset extends FolderArtifact {
	private String datasetId;
	
	public Dataset(String datasetId, File file) {
		super(null, file, true);
		this.datasetId = datasetId;
	}

	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
	}
	
	

	@Override
	public String toString() {
		return "Dataset [datasetId=" + datasetId + ", getAbsolutePath()="
				+ getAbsolutePath() + "]";
	}

}
