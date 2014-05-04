package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.mir;

import java.io.File;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.env.DataDirRoot;

public class ResultDir4Run extends FolderArtifact {
	private RunActivity run;

	public ResultDir4Run(RunActivity run, DataDirRoot dataDir) {
		this(run, dataDir.newFolder("result_"));
	}

	public ResultDir4Run(RunActivity run, File resDir) {
		super(null, resDir);
		this.run = run;
	}
	
	public RunActivity getRun() {
		return run;
	}

	public void setRun(RunActivity run) {
		this.run = run;
	}

	@Override
	public String toString() {
		return "ResultDir4Run [run=" + run + "]";
	}
}
