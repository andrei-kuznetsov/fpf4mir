package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.run;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifactList;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Run;

public class TestRunResult_FileArtifactList extends FileArtifactList {
	private static final long serialVersionUID = 1L;
	private Run run;

	public TestRunResult_FileArtifactList(Run run, FileArtifactList list) {
		super(R.id.TestRunResult_FileList, list);
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
		return "TestRunResult_FileArtifactList [run=" + run + "]";
	}

}
