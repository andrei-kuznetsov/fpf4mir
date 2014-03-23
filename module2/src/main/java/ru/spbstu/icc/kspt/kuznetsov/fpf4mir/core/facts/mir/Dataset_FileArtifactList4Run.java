package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class Dataset_FileArtifactList4Run {
	private Run run;
	private Dataset_FileArtifactList list;
	
	public Dataset_FileArtifactList4Run(Run run, Dataset_FileArtifactList list) {
		this.run = run;
		this.list = list;
	}

	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
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
