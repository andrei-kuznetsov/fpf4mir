package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.ActivityRelatedFactBase;

public class Dataset4Run extends ActivityRelatedFactBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1186640503996445202L;
	private Dataset dataset;
	
	public Dataset4Run(Activity run, Dataset dataset) {
		super(run);
		this.dataset = dataset;
	}

	public Dataset getDataset() {
		return dataset;
	}

	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}

	@Override
	public String toString() {
		return "Dataset4Run [run=" + getActivity() + ", dataset=" + dataset + "]";
	}
	
}
