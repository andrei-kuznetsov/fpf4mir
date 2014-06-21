package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class Utils {
	private static final int maxFileSize = 500 * 1024 * 1024;
	private static final int maxMemSize = 4 * 1024 * 1024;
	
	public static final String filePathRoot = "/home/andrei/OpenShift/datadir/jetty/";
	
	public static class UploadedFileDetails{
		public String baseDir = "";
		public List<String> fileNames = new LinkedList<String>();
	}
	
	static UploadedFileDetails doUploadOriginalArtifact(HttpServletRequest request) throws Exception {
		boolean isMultipart;
		String filePath = "/home/andrei/OpenShift/datadir/jetty/";
		String tmpPath = "/home/andrei/OpenShift/datadir/jetty/";
		File base = null;
		UploadedFileDetails uploadedFiles = new UploadedFileDetails();

		File file;

		// Check that we have a file upload request
		isMultipart = ServletFileUpload.isMultipartContent(request);

		if (!isMultipart) {
			throw new IOException("The request was not a multipart message");
		}

		base = new File(filePath, /* UUID.randomUUID().toString() */
		String.valueOf(new Date().getTime()));
		base.mkdirs();
		uploadedFiles.baseDir = base.getAbsolutePath();
		
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// maximum size that will be stored in memory
		factory.setSizeThreshold(maxMemSize);
		// Location to save data that is larger than maxMemSize.
		factory.setRepository(new File(tmpPath));

		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		// maximum file size to be uploaded.
		upload.setSizeMax(maxFileSize);

		// Parse the request to get file items.
		List<FileItem> fileItems = upload.parseRequest(request);

		// Process the uploaded file items
		Iterator<FileItem> i = fileItems.iterator();

		while (i.hasNext()) {
			FileItem fi = (FileItem) i.next();
			if (!fi.isFormField()) {
				// Get the uploaded file parameters
//					String fieldName = fi.getFieldName();
				String fileName = fi.getName();
				uploadedFiles.fileNames.add(fileName);
//					String contentType = fi.getContentType();
//					boolean isInMemory = fi.isInMemory();
//					long sizeInBytes = fi.getSize();
				// Write the file
				if (fileName.lastIndexOf("\\") >= 0) {
					file = new File(base, fileName.substring(fileName
							.lastIndexOf("\\")));
				} else {
					file = new File(base, fileName.substring(fileName
							.lastIndexOf("\\") + 1));
				}
				fi.write(file);
			}
		}
			
		return uploadedFiles;
	}
}
