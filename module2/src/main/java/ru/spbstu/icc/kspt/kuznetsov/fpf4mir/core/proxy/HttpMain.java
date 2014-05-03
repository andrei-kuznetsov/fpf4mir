package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Application;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;
import org.eclipse.jetty.server.handler.ErrorHandler;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.KBRunner;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.ReqNewOriginalArtifact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestFact;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public class HttpMain extends AbstractHandler {
	private static final String PATH_STATUS = "/status";
	private DeploymentSession session = null;
	private KBRunner runner = null;

	private static final int maxFileSize = 50 * 1024 * 1024;
	private static final int maxMemSize = 4 * 1024 * 1024;

	private static volatile long reqRefId = 1;
	
	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		if ("/favicon.ico".equals(target)) {
			return;
		}

		System.out.println(">> target: " + target);

		if (request.getMethod().equals("POST")) {
			if (target.equals("/original_artifact")) {
				doAssertNewOriginalArtifact(request, response);
				baseRequest.setHandled(true);
			}
		} else if (request.getMethod().equals("GET")) {
			if (target.equals(PATH_STATUS)) {
				doProvideStatus(request, response);
			} else if (target.equals("/status/update")) {
				doProvideStatusUpdate(request, response);
			} else {
				doSendIndex(request, response);
			}

			baseRequest.setHandled(true);
		}
	}

	private void doAssertNewOriginalArtifact(HttpServletRequest request,
			HttpServletResponse response) throws IOException, ServletException {
		List<File> files = doUploadOriginalArtifact(request, response);
		File oa;

		if (files.size() == 1) {
			oa = files.get(0);
		} else {
			oa = files.get(0).getParentFile();
		}

		try {
			initSession(); // recreate new session
			runner = new KBRunner(session);
			RequestFact req = new ReqNewOriginalArtifact(oa);
			req.setRefId(reqRefId++);
			session.assertFactAndRun(req);
			response.sendRedirect(PATH_STATUS);
		} catch (Exception e) {
			throw new ServletException("Can't init deployment session", e);
		}
	}

	private void doSendIndex(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		IOUtils.copy(
				getClass().getClassLoader().getResourceAsStream(
						"webapp/index.html"), response.getOutputStream());

	}

	private void doProvideStatusUpdate(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub
		RequestStatus status = session.getRequestStatus(reqRefId);
		try {
			HTMLProducer.produceHTMLPage(status, response, "Status");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void doProvideStatus(HttpServletRequest request,
			HttpServletResponse response) {
		// TODO Auto-generated method stub

	}

	private List<File> doUploadOriginalArtifact(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		boolean isMultipart;
		String filePath = "/home/andrei/OpenShift/datadir/jetty/";
		String tmpPath = "/home/andrei/OpenShift/datadir/jetty/";
		File base = null;
		List<File> uploadedFiles = new LinkedList<File>();

		File file;

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			return uploadedFiles;
		}

		base = new File(filePath, /* UUID.randomUUID().toString() */
		String.valueOf(new Date().getTime()));
		base.mkdirs();

		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(tmpPath));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		try {
			// Parse the request to get file items.
			List<FileItem> fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator<FileItem> i = fileItems.iterator();

			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			while (i.hasNext()) {
				FileItem fi = (FileItem) i.next();
				if (!fi.isFormField()) {
					// Get the uploaded file parameters
					String fieldName = fi.getFieldName();
					String fileName = fi.getName();
					String contentType = fi.getContentType();
					boolean isInMemory = fi.isInMemory();
					long sizeInBytes = fi.getSize();
					// Write the file
					if (fileName.lastIndexOf("\\") >= 0) {
						file = new File(base, fileName.substring(fileName
								.lastIndexOf("\\")));
					} else {
						file = new File(base, fileName.substring(fileName
								.lastIndexOf("\\") + 1));
					}
					fi.write(file);
					uploadedFiles.add(file);
					out.println("Uploaded Filename: " + fileName + "<br>");
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return uploadedFiles;
	}

	private void initSession() throws Exception {
		if (session != null) {
			session.reset();
		} else {
			session = new DeploymentSession(/*oa, "/media/andrei/WORK/phd/oma/test"*/);
			session.init();
		}
	}

	public static void main(String[] args) throws Exception {
		Server server = new Server(8080);
		//server.setHandler(new HttpMain());
		  ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
		  context.setContextPath("/");
		  ServletHolder h = new ServletHolder(new HttpServletDispatcher());
		  h.setInitParameter(Application.class.getCanonicalName(), RESTService.class.getCanonicalName());
		  context.addServlet(h, "/*");
		  server.setHandler(context);

		server.start();
		server.join();
	}
}
