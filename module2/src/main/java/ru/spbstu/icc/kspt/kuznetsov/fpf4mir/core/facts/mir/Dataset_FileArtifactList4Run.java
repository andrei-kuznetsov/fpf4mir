package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class Dataset_FileArtifactList4Run {
	private RunActivity run;
	private Dataset_FileArtifactList list;
	
	public Dataset_FileArtifactList4Run(RunActivity run, Dataset_FileArtifactList list) {
		this.run = run;
		this.list = list;
	}

	public RunActivity getRun() {
		return run;
	}

	public void setRun(RunActivity run) {
		this.run = run;
	}

	public Dataset_FileArtifactList getList() {
		return list;
	}

	public void setList(Dataset_FileArtifactList list) {
		this.list = list;
	}

	@Override
	public String toString() {
		return "Dataset_FileArtifactList4Run [run=" + run + ", list=" + list
				+ "]";
	}
	
}
