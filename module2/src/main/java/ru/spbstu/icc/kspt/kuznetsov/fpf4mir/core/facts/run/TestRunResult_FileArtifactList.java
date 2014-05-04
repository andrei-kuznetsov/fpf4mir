package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.RunActivity;

public class TestRunResult_FileArtifactList extends FileArtifactList {
	private static final long serialVersionUID = 1L;
	private RunActivity run;

	public TestRunResult_FileArtifactList(RunActivity run, FileArtifactList list) {
		super(R.id.TestRunResult_FileList, list);
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
		return "TestRunResult_FileArtifactList [run=" + run + "]";
	}

}
