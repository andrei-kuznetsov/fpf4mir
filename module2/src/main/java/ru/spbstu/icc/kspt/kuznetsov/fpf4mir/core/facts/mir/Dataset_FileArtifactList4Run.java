package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class Dataset_FileArtifactList4Run extends ActivityRelatedFactBase{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4734458785715993173L;
	private Dataset_FileArtifactList list;
	
	public Dataset_FileArtifactList4Run(Activity run, Dataset_FileArtifactList list) {
		super(run);
		this.list = list;
	}

	public Dataset_FileArtifactList getList() {
		return list;
	}

	public void setList(Dataset_FileArtifactList list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Dataset_FileArtifactList4Run [run=" + getActivity() + ", list=" + list
				+ "]";
	}
	
}
