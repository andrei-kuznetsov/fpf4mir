package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericDownloadStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy.Utils;

public class DownloadActionHandler implements ActionHandler {

	@Override
	public void process(Action action, StatefulKnowledgeSession ksession)
			throws Exception {
		DownloadAction da = (DownloadAction) action;
		
		String fileExt = da.getUri().getPath();
		fileExt = fileExt.substring(fileExt.lastIndexOf('.'));
		
		File dst = new File(Utils.filePathRoot, UUID.randomUUID().toString() + fileExt);
		
		GenericFileArtifact fa = new GenericFileArtifact(da.getActivity(), dst.getParent(), dst.getName());
		fa.setName(da.getParameter().getName());
		
		int status = 500;
		
		FileUtils.copyURLToFile(da.getUri().toURL(), dst);
		status = 200;
		
		ksession.retract(ksession.getFactHandle(action));
		ksession.insert(new GenericDownloadStatus(da.getActivity(), da.getParameter(), status, fa));
	}
	
}
