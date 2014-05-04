package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class Dataset4Run {
	private RunActivity run;
	private Dataset dataset;
	
	public Dataset4Run(RunActivity run, Dataset dataset) {
		this.run = run;
		this.dataset = dataset;
	}

	public RunActivity getRun() {
		return run;
	}

	public void setRun(RunActivity run) {
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
