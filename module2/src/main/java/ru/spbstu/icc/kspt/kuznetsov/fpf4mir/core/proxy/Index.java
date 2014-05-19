package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URI;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericFileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericFolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqDeployExecutable;

@Path("/")
public class Index {

	private static final String PATH_STATUS = "/status";
	private static final String PATH_REQUEST_STATUS = PATH_STATUS + "/request";

	private DeploymentSession session = new DeploymentSession();
	private static volatile long reqRefId = 1;

	@GET
	@Produces("text/html")
	public Response index() {
		return Response.ok(
				getClass().getClassLoader().getResourceAsStream(
						"webapp/index.html"), "text/html;charset=utf-8")
				.build();
	}

	@POST
	@Path("/original_artifact")
	public Response uploadProcess(@Context HttpServletRequest httpreq)
			throws Exception {

		List<File> files = Utils.doUploadOriginalArtifact(httpreq);

		ReqDeployExecutable req = new ReqDeployExecutable(Activity.USER);
		req.setRefId(reqRefId++);
		req.setDeploymentName(R.id.MainDeployment);

		Artifact userArtifact;
		Object artifactAlias;
		
		if (files.size() == 1) {
			userArtifact = new FileArtifact(Activity.USER, files.get(0));
			artifactAlias = new GenericFileArtifactAlias();
			((GenericFileArtifactAlias)artifactAlias).reset(req, R.artifact.main , (FileArtifact)userArtifact);
		} else {
			userArtifact = new FolderArtifact(Activity.USER, files.get(0).getParentFile());
			artifactAlias = new GenericFolderArtifactAlias();
			((GenericFolderArtifactAlias)artifactAlias).reset(req, R.artifact.main, (FolderArtifact) userArtifact);
		}

		try {
			session.reset(); // recreate new session
			session.assertFactAndRun(req, userArtifact, artifactAlias);
			
			return Response.seeOther(new URI(PATH_REQUEST_STATUS + "/" + req.getRefId())).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Can't init deployment session", e);
		}
	}

	@GET
	@Path(PATH_REQUEST_STATUS + "/{reqId}")
	public void getStatus(@Context HttpServletResponse response,
			@Context HttpServletRequest request, @PathParam("reqId") long reqId) throws IOException {
		List<QResult> status = session.getRequestStatus(reqId);
		
		PrintWriter out = response.getWriter();
		HTMLProducer.produceHTMLPage(status, response, "Status");
		out.close();
	}

}
