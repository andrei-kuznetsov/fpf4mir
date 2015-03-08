package utils;

import java.io.File;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.drools.runtime.StatefulKnowledgeSession;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionhandlers.ActionHandler;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.Action;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.DownloadAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.impl.GenericDownloadStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.ArtifactRef;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.artifact.impl.GenericFolderArtifact;

public class TestDownloadActionHandlerImpl implements ActionHandler{
	public static class DlResult{
		URI uri;
		int status;
		File target;
		
		public DlResult(String uri, int status, File target) {
			this(URI.create(uri), status, target);
		}

		public DlResult(URI uri, int status, File target) {
			this.uri = uri; 
			this.status = status;
			this.target = target;
		}
		
		public int getStatus() {
			return status;
		}

		public void setStatus(int status) {
			this.status = status;
		}

		public File getTarget() {
			return target;
		}

		public void setTarget(File target) {
			this.target = target;
		}

		public URI getUri() {
			return uri;
		}

		public void setUri(URI uri) {
			this.uri = uri;
		}
	}
	
	Map<URI, DlResult> mapping = new HashMap<>();
	
	public TestDownloadActionHandlerImpl(DlResult[] dlResults) {
		for (DlResult i : dlResults){
			mapping.put(i.getUri(), i);
		}
	}

	@Override
	public void process(Action action, StatefulKnowledgeSession ksession)
			throws Exception {
		DownloadAction da = (DownloadAction) action;
		DlResult res = mapping.get(da.getUri());
		if (res == null){
			res = new DlResult(da.getUri(), 404, null);
		}
		
		Artifact target = null;
		if (res.target != null){
			if (res.target.isFile())
				target = new GenericFileArtifact(action.getActivity(), res.target.getParent(), res.target.getName());
			else 
				target = new GenericFolderArtifact(action.getActivity(), res.target.getParent(), res.target.getName());
		}
		final GenericDownloadStatus status = new GenericDownloadStatus(da.getActivity(), (ArtifactRef) da.getParameter(), res.status, target);
		ksession.retract(ksession.getFactHandle(action));
    	ksession.insert(status);
	}

}
