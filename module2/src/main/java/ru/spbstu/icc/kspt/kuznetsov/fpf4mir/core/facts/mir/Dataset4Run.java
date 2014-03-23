package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class Dataset4Run {
	private Run run;
	private Dataset dataset;
	
	public Dataset4Run(Run run, Dataset dataset) {
		this.run = run;
		this.dataset = dataset;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	public Dataset getDataset() {
		return dataset;
	}

	public void setDataset(Dataset dataset) {
		this.dataset = dataset;
	}

	@Override
	public String toString() {
		return "Dataset4Run [run=" + run + ", dataset=" + dataset + "]";
	}
	
}
