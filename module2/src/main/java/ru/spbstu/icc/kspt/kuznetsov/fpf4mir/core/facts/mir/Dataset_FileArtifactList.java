package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;

public class Dataset_FileArtifactList extends FileArtifactList {
	private static final long serialVersionUID = 1L;
	private Dataset dataset;
	private File materializedFile;

	public Dataset_FileArtifactList(Activity activity, Dataset dataset, String pattern, FolderArtifact tmpDir) {
		super(activity, dataset.getFileArtifactListForPattern(pattern));
		this.dataset = dataset;
		
		if (tmpDir != null){
			materializedFile = materialize(tmpDir._getFile());
		} else {
			materializedFile = null;
		}
	}
	
	public Dataset getDataset() {
		return dataset;
	}

	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}
	
	public String getAbsolutePath(){
		if (materializedFile != null) {
			return materializedFile.getAbsolutePath();
		} else {
			return null;
		}
	}
	
	@Override
	public String toString() {
		return "Dataset_FileArtifactList [dataset=" + dataset
				+ ", materializedFile=" + materializedFile + "]";
	}
}
