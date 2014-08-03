package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Reader;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.actions.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.ActivityStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.activity.impl.ActivityBase;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.request.RequestStatusRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.rest.ReqRestCommand;

@Path("/rest")
public class Index {

	private static final String PATH_ROOT = "/rest";
	private static final String PATH_STATUS = "/status";
	private static final String PATH_USERACTION = "/useraction";
	private static final String PATH_REQUEST_STATUS = PATH_STATUS + "/request";

	private DeploymentSession session = DeploymentSession.getInstance();

	private static final Logger log = Logger.getLogger(Index.class);

	private ObjectMapper mapper = new ObjectMapper(); // can reuse, share
														// globally

	@GET
	@Path("/dbg")
	public void dbgAll(@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException,
			IOException {
		HashMap<Object, List<Object>> tree = new HashMap<>();
		List<Activity> roots = session.getRoots();
		if (roots.size() != 1) {
			log.warn("Number of root activities should be 1, but was " + roots.size());
		}
		
		for (Activity root : roots){
			fillDbgTraceTree(tree, root);
		}

		RequestDispatcher dispatcher = request
				.getRequestDispatcher("/jsp/dbg_tree.jsp");
		request.setAttribute("tree", tree);
		request.setAttribute("roots", roots);
		dispatcher.forward(request, response);
	}

	@GET
	@Path("/dbg/store")
	public String dbgStoreSession() throws ServletException, IOException {
		if (session != null) {
			File f = new File("./ksession");
			log.info("Stroring ksession to file " + f.getAbsolutePath());
			FileOutputStream fos = new FileOutputStream(f);
			session.storeKSession(fos);
			fos.close();
			return new Date() + " : Successfully stored";
		} else {
			return new Date() + " : No sessions currently exists";
		}
	}

	@GET
	@Path("/dbg/restore")
	public String dbgRestoreSession() throws Exception {
		File f = new File("./ksession");
		if (f.canRead()) {
			log.info("Readig ksession from file " + f.getAbsolutePath());
			FileInputStream fis = new FileInputStream(f);
			session.reset(fis);
			fis.close();
			return new Date() + " : Successfully restored";
		} else {
			return new Date() + " : No previously stored sessions found";
		}
	}

	@GET
	@Path("/dbg/reset")
	public Response dbgResetSession() throws Exception {
		session.reset(); // recreate new session
		session.assertFact(ActivityBase.USER);
		session.run();
		return Response.seeOther(new URI("/kb/deploy")).build();
	}
	
	@GET
	@Path("/files")
	public File dbgAll(@QueryParam("file") String fileName)
			throws ServletException, IOException {
		return new File(fileName);
	}

	private void fillDbgTraceTree(HashMap<Object, List<Object>> tree, Object key) {

		if (tree.containsKey(key)) {
			return;
		} else {
			List<Object> lst = null;
			if (key instanceof Activity) {
				lst = session.getActivityRelatedFacts((Activity) key);
			} else if (key instanceof RequestFact) {
				lst = session.getRequestRelatedFacts((RequestFact) key);
			} else if (key instanceof ActivityStatus) {
				lst = session.getActivityStatusRelatedFacts((ActivityStatus) key);
			} else if (key instanceof RequestStatus) {
				lst = session.getRequestStatusRelatedFacts((RequestStatus) key);
			} else if (key instanceof ActivityResult) {
				lst = session.getActivityResultRelatedFacts((ActivityResult) key);
			}

			tree.put(key, lst);
			if (lst != null) {
				for (Object i : lst) {
					fillDbgTraceTree(tree, i);
				}
			}
		}
	}

	@GET
	@POST
	@Path("/echo")
	public void echo(@Context HttpServletRequest req,
			@Context HttpServletResponse resp) throws IOException {
		IOUtils.copy(req.getInputStream(), resp.getOutputStream());
		resp.getOutputStream().close();
		req.getInputStream().close();
	}

	@GET
	@Path(PATH_USERACTION + "/{actionName}/{id}")
	public void getUserAction(@Context HttpServletResponse response,
			@Context HttpServletRequest request, @PathParam("id") long id,
			@PathParam("actionName") String actionName,
			@QueryParam("r") int reqRefId)
			throws ServletException, IOException {

		UserAction uaction = session.getUserAction(id);
		if (uaction != null
				&& uaction.getClass().getSimpleName().equals(actionName)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/"
					+ actionName + ".jsp");
			request.setAttribute("uaction", uaction);
			request.setAttribute("r", reqRefId);
			dispatcher.forward(request, response);
		} else {
			response.sendError(404, "No action '" + actionName
					+ "' found with id=" + id);
		}
	}

	@POST
	@Path("/assert/activity/{id}")
	public void assertFactForActivity(@Context HttpServletRequest request,
			@PathParam("id") long id) throws Exception {
		assertFactForActivityImpl(request.getReader(), id);
		session.run();
	}

	@POST
	@Path(PATH_USERACTION + "/{actionName}/{id}/handled")
	public Response handleUserAction(@Context HttpServletRequest request,
			@PathParam("id") long id, @PathParam("actionName") String actionName, @QueryParam("r") int reqRefId)
			throws Exception {

		UserAction uaction = session.getUserAction(id);
		if (uaction != null
				&& uaction.getClass().getSimpleName().equals(actionName)) {

			assertFactForActivityImpl(request.getReader(), uaction.getActivity());
			session.setFactHandled(uaction);
			session.run();
			
			return Response.seeOther(
					new URI("/rest/" + PATH_REQUEST_STATUS + "/" + reqRefId))
					.build();
		} else {
			log.warn("No action '" + actionName + "' found with id=" + id);
			return Response.status(404).build();
		}
	}

	private void assertFactForActivityImpl(Reader r, Activity activity)
			throws Exception {
		JsonNode root = mapper.readTree(r);
		if (root.isArray()) {
			for (JsonNode i : root) {
				ActivityRelatedFact fact = (ActivityRelatedFact) session
						.newFact(i);
				fact.setActivity(activity);
				session.assertFact(fact);
			}
		} else {
			ActivityRelatedFact fact = (ActivityRelatedFact) session
					.newFact(root);
			fact.setActivity(activity);
			session.assertFact(fact);
		}
	}

	private void assertFactForActivityImpl(Reader r, long id) throws Exception {
		Activity activity = session.getActivity(id);
		if (activity == null) {
			throw new Exception("Activity with id=" + id + " not found");
		}
		assertFactForActivityImpl(r, activity);
	}

	@GET
	@Path(PATH_REQUEST_STATUS + "/{reqId}")
	public void getStatus(@Context HttpServletResponse response,
			@Context HttpServletRequest request, @PathParam("reqId") long reqId)
			throws IOException, ServletException {
		try {
			List<QResult> status = session.getRequestStatus(reqId);

			List<RequestStatusRelatedFact> extras = new LinkedList<RequestStatusRelatedFact>();
			for (QResult i : status) {
				if (i.extras != null) {
					extras.addAll(i.extras);
				}
			}

			RequestDispatcher dispatcher = request
					.getRequestDispatcher("/jsp/status.jsp");
			request.setAttribute("extras", extras);
			request.setAttribute("status", status);
			dispatcher.forward(request, response);
		} catch (RuntimeException rt) {
			rt.printStackTrace();
			throw rt;
		}
	}
/*
	@POST
	@Path("/execute/{many:.*}")
	public Response executeRequest(@Context HttpServletRequest httpreq)
			throws Exception {

		UploadedFileDetails files = Utils.doUploadOriginalArtifact(httpreq);

		RestRequestCommand req = new RestRequestCommand(Activity.USER);

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
		
		try {
			session.run();
			return Response.seeOther(
					new URI(PATH_ROOT + PATH_REQUEST_STATUS + "/"
							+ req.getRefId())).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Can't process request", e);
		}
	}
*/
}
