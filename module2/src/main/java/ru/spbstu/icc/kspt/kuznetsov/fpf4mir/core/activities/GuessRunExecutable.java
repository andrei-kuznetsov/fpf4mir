package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.activities;

import java.util.Date;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewActivity;

public class GuessRunExecutable extends Activity{
	private FolderArtifact deployFolder;  

	public GuessRunExecutable(FolderArtifact deployFolder, int number, Date date,
			ReqNewActivity request) {
		super(R.id.GuessRunExecutableActivity, number, date, request);
		this.deployFolder = deployFolder;
	}

	public FolderArtifact getDeployFolder() {
		return deployFolder;
	}

	public void setDeployFolder(FolderArtifact deployFolder) {
		this.deployFolder = deployFolder;
	}

}
