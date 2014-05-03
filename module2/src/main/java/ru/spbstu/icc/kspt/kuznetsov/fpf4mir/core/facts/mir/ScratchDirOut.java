package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env.DataDirRoot;

public class ScratchDirOut extends FolderArtifact{
	private String datasetId;
	
	public ScratchDirOut(String datasetId, DataDirRoot dataDir) {
		super(null, dataDir.newFolder());
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
		return "ScratchDirOut [datasetId=" + datasetId + "]";
	}
	
}
