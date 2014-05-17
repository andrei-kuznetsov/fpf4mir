package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericActivity;

public class ReqExtract extends RequestFactBase implements ReqNewActivity {
	private FileArtifact file;

	public ReqExtract(Activity parentActivity) {
		super(parentActivity);
	}

	public ReqExtract(long refId, Activity parentActivity) {
		super(refId, parentActivity);
	}

	public ReqExtract(FileArtifact file, Activity parentActivity) {
		super(parentActivity);
		this.file = file;
	}

	public FileArtifact getFile() {
		return file;
	}

	public void setFile(FileArtifact file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "ReqExtract [file=" + file + ", getRefId()=" + getRefId() + "]";
	}

	@Override
	public Activity newActivityInstance() {
		java.util.Date date = new java.util.Date();
		return new GenericActivity(R.id.ExtractActivity, (int)date.getTime(), date, this);
	}

	@Override
	public String getActivityName() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
