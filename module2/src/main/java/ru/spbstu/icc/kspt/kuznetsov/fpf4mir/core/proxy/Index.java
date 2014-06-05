package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.IOException;
import java.io.Reader;
import java.net.URI;
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
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;

import org.apache.commons.io.IOUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actionfacts.UserAction;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Artifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FileArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.FolderArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.R;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericFileArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.generic.GenericFolderArtifactAlias;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy.Utils.UploadedFileDetails;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqDeployExecutable;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.ActivityRelatedFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.utils.RequestStatusRelatedFact;

@Path("/rest")
public class Index {
	
	private static final String PATH_ROOT = "/rest";
	private static final String PATH_STATUS = "/status";
	private static final String PATH_USERACTION = "/useraction";
	private static final String PATH_REQUEST_STATUS = PATH_STATUS + "/request";

	private DeploymentSession session = new DeploymentSession();
	private static volatile long reqRefId = 1;

	private static final Logger log = Logger.getLogger(Index.class);

	private ObjectMapper mapper = new ObjectMapper(); // can reuse, share globally

	@GET
	@Path("/dbg")
	public void dbgAll(@Context HttpServletRequest request,
			@Context HttpServletResponse response) throws ServletException, IOException{
		HashMap<Object, List<Object>> tree = new HashMap<>();
		fillDbgTraceTree(tree, Activity.USER);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/dbg_tree.jsp");
		request.setAttribute("tree", tree);
		request.setAttribute("root", Activity.USER);
		dispatcher.forward(request, response);
	}
	
	
	private void fillDbgTraceTree(HashMap<Object, List<Object>> tree,
			Object key) {
		
		if (tree.containsKey(key)){
			return;
		} else {
			List<Object> lst = null;
			if (key instanceof Activity){
				lst = session.getActivityRelatedFacts((Activity)key);
			} else if (key instanceof RequestFact) {
				lst = session.getRequestRelatedFacts((RequestFact)key);
			} else if (key instanceof RequestStatus){
				lst = session.getRequestStatusRelatedFacts((RequestStatus)key);
			}
			
			tree.put(key, lst);
			if (lst != null){
				for (Object i : lst){
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

	@POST
	@Path("/original_artifact")
	public Response uploadProcess(@Context HttpServletRequest httpreq)
			throws Exception {

		UploadedFileDetails files = Utils.doUploadOriginalArtifact(httpreq);

		ReqDeployExecutable req = new ReqDeployExecutable(Activity.USER);
		req.setRefId(reqRefId++);
		req.setDeploymentName(R.id.MainDeployment);

		Artifact userArtifact;
		Object artifactAlias;

		if (files.fileNames.size() == 1) {
			userArtifact = new FileArtifact(Activity.USER, files.baseDir,
					files.fileNames.get(0));
			artifactAlias = new GenericFileArtifactAlias();
			((GenericFileArtifactAlias) artifactAlias).reset(req,
					R.artifact.main, (FileArtifact) userArtifact);
		} else {
			userArtifact = new FolderArtifact(Activity.USER, files.baseDir, "");
			artifactAlias = new GenericFolderArtifactAlias();
			((GenericFolderArtifactAlias) artifactAlias).reset(req,
					R.artifact.main, (FolderArtifact) userArtifact);
		}

		try {
			session.reset(); // recreate new session
			session.assertFactAndRun(req, userArtifact, artifactAlias);

			return Response.seeOther(
					new URI(PATH_ROOT + PATH_REQUEST_STATUS + "/"
							+ req.getRefId())).build();
		} catch (Exception e) {
			e.printStackTrace();
			throw new ServletException("Can't init deployment session", e);
		}
	}

	@GET
	@Path(PATH_USERACTION + "/{actionName}/{id}")
	public void getUserAction(@Context HttpServletResponse response,
			@Context HttpServletRequest request, @PathParam("id") long id,
			@PathParam("actionName") String actionName)
			throws ServletException, IOException {

		UserAction uaction = session.getUserAction(id);
		if (uaction != null
				&& uaction.getClass().getSimpleName().equals(actionName)) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/jsp/"
					+ actionName + ".jsp");
			request.setAttribute("uaction", uaction);
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
	}

	@POST
	@Path(PATH_USERACTION + "/{actionName}/{id}/handled")
	public Response handleUserAction(@Context HttpServletRequest request,
			@PathParam("id") long id, @PathParam("actionName") String actionName)
			throws Exception {

		UserAction uaction = session.getUserAction(id);
		if (uaction != null && uaction.getClass().getSimpleName().equals(actionName)) {

			session.setFactHandled(uaction);
			assertFactForActivityImpl(request.getReader(), uaction.getActivity());

			return Response.ok().build();
		} else {
			log.warn("No action '" + actionName + "' found with id=" + id);
			return Response.status(404).build();
		}
	}

	private void assertFactForActivityImpl(Reader r, Activity activity) throws Exception {
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
		session.run();
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

}
