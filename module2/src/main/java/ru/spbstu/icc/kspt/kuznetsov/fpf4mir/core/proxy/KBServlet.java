package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.IOException;
import java.util.Map.Entry;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest.RestArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest.RestFormArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest.RestPathArgument;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest.ReqRestCommand;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy.Utils.UploadedFileDetails;

public class KBServlet extends HttpServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = -168607551077973650L;
	
	private DeploymentSession session = DeploymentSession.getInstance();

	@Override
    protected void doPost(HttpServletRequest httpreq, HttpServletResponse resp)
    		throws ServletException, IOException {

		UploadedFileDetails files;
		try {
			files = Utils.doUploadOriginalArtifact(httpreq);
		} catch (Exception e1) {
			resp.sendError(400, e1.getMessage());
			e1.printStackTrace();
			return;
			//throw new IOException("Can't upload files", e1);
		}

		ReqRestCommand req = new ReqRestCommand(Activity.USER);

		Artifact userArtifact;
		RestArtifact artifactAlias;

		if (files.fileNames.size() == 1) {
			userArtifact = new FileArtifact(Activity.USER, files.baseDir, files.fileNames.get(0));
		} else {
			userArtifact = new FolderArtifact(Activity.USER, files.baseDir, "");
		}
		artifactAlias = new RestArtifact(req, userArtifact);

		session.assertFact(req, userArtifact, artifactAlias);
		int reqArgument = 0;
		for (String i : httpreq.getPathInfo().split("/")){
			RestPathArgument arg = new RestPathArgument(req, reqArgument++, i);
			session.assertFact(arg);
		}

		for (Entry<String, String> i : files.formFields.entrySet()){
			RestFormArgument arg = new RestFormArgument(req, i.getKey(), i.getValue());
			session.assertFact(arg);
		}
		
		try {
			session.run();
			resp.sendRedirect("/rest/status/request/" + req.getRefId());
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Can't process request", e);
		}
    }
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/exec.jsp");
		dispatcher.forward(request, response);
    }
}
