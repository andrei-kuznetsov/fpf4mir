package ru.spbstu.icc.kspt.kuznetsov.codestore;

//Import required java libraries
import java.io.*;
import java.util.*;

import javax.ejb.EJB;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;
import org.apache.log4j.Logger;

import ru.spbstu.icc.kspt.kuznetsov.codestore.dao.SubmissionFacade;

public class UploadServlet extends HttpServlet {

	private boolean isMultipart;
	private String filePath;
	private String tmpPath;
	private int maxFileSize = 50 * 1024 * 1024;
	private int maxMemSize = 4 * 1024;
	private File file;

	private static final Logger log = Logger.getLogger(UploadServlet.class);

	@EJB
	private SubmissionFacade submissions;

	public void init() {
		// Get the file location where it would be stored.
		filePath = System.getenv("OPENSHIFT_DATA_DIR");
		if (filePath == null) {
			filePath = "/tmp/datadir/";
			log.warn("Environment variable 'OPENSHIFT_DATA_DIR' was not set. Using default location: "
					+ filePath);
		}

		tmpPath = System.getenv("OPENSHIFT_TMP_DIR");
		if (tmpPath == null) {
			tmpPath = "/tmp/tmpdir/";
			log.warn("Environment variable 'OPENSHIFT_TMP_DIR' was not set. Using default location: "
					+ tmpPath);
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);
		response.setContentType("text/html");
		java.io.PrintWriter out = response.getWriter();
		if (!isMultipart) {
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Servlet upload</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<p>No file uploaded</p>");
			out.println("</body>");
			out.println("</html>");
			return;
		}
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
			List fileItems = upload.parseRequest(request);

			// Process the uploaded file items
			Iterator i = fileItems.iterator();

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
					String shortName = mkShortFileName(fileName);
					String submissionId = UUID.randomUUID().toString();
					//String submissionId = UUID.nameUUIDFromBytes(shortName.getBytes()).toString();
					
					File file = prepareFile(shortName, submissionId);
					fi.write(file);
					out.println("Uploaded Filename: " + fileName + "<br>");

					submissions.addSubmission(submissionId, shortName);
				}
			}
			out.println("</body>");
			out.println("</html>");
		} catch (Exception ex) {
			System.out.println(ex);
		}
	}

	private File prepareFile(String shortName, String submissionId) {
		File parentDir = new File(filePath + '/' + submissionId);
		parentDir.mkdirs();
		
		final File f = new File(parentDir, shortName);
		log.info("Uploading file to " + f.getAbsolutePath());
		
		return f;
	}

	private String mkShortFileName(String fileName) {
		final File f = new File(fileName);
		return f.getName();
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {

		throw new ServletException("GET method used with "
				+ getClass().getName() + ": POST method required.");
	}
}