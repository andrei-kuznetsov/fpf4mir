package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.DataDirRoot;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run.RunFact;

public class ResultDir4Run extends FolderArtifact implements RunFact{
	private Run run;

	public ResultDir4Run(Run run, DataDirRoot dataDir) {
		this(run, dataDir.newFolder("result_"));
	}

	public ResultDir4Run(Run run, File resDir) {
		super(null, resDir);
		this.run = run;
	}
	
	public Run getRun() {
		return run;
	}

	public void setRun(Run run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "ResultDir4Run [run=" + run + "]";
	}
}
