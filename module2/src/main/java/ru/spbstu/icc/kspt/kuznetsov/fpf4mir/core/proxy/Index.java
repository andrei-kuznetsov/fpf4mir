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
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewOriginalArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

@Path("/")
public class Index {

	private static final String PATH_STATUS = "/status";

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
		File oa;

		if (files.size() == 1) {
			oa = files.get(0);
		} else {
			oa = files.get(0).getParentFile();
		}

		try {
			session.reset(); // recreate new session
			RequestFact req = new ReqNewOriginalArtifact(oa);
			req.setRefId(reqRefId++);
			session.assertFactAndRun(req);
			return Response.seeOther(new URI(PATH_STATUS + "/" + req.getRefId())).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Can't init deployment session", e);
		}
	}

	@GET
	@Path(PATH_STATUS + "/{reqId}")
	public void getStatus(@Context HttpServletResponse response,
			@Context HttpServletRequest request, @PathParam("reqId") long reqId) throws IOException {
		RequestStatus status = session.getRequestStatus(reqRefId);
		
		PrintWriter out = response.getWriter();
		HTMLProducer.produceHTMLPage(status, response, "Status");
		out.close();
	}

}
