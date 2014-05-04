package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import java.io.File;
import java.util.UUID;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ActionFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.ExtractAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actions.ZipUnzip;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;

public class ExtractActionHandler implements ActionHandler {
	public void process(ActionFact a, StatefulKnowledgeSession ksession){
		final ExtractAction action = (ExtractAction)a;
		String targetFileName = UUID.randomUUID().toString();
		File srcFile = action.getFile();
		File targetDir = new File(srcFile.getParentFile(), targetFileName);
		
		ZipUnzip.unzip(srcFile, targetDir.getAbsolutePath());
		FolderArtifact fc = new FolderArtifact(action.getActivity(), targetDir);
		
		ksession.retract(ksession.getFactHandle(action));
		ksession.insert(fc);
	}
}
