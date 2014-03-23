package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class ScratchDir extends FolderArtifact {
	private String datasetId;
	
	public ScratchDir(String datasetId, File file) {
		super(null, file);
		this.datasetId = datasetId;
	}

	public ScratchDir(String datasetId, FolderArtifact artifact) {
		this(datasetId, artifact.getFile());
	}
	
	public String getDatasetId() {
		return datasetId;
	}

	public void setDatasetId(String datasetId) {
		this.datasetId = datasetId;
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
		if (!(obj instanceof ScratchDir))
			return false;
		ScratchDir other = (ScratchDir) obj;
		if (datasetId == null) {
			if (other.datasetId != null)
				return false;
		} else if (!datasetId.equals(other.datasetId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "ScratchDir [datasetId=" + datasetId + "]";
	}
}
