package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestStatus;

public class HTMLProducer {

	static void produceHTMLPageBegin(HttpServletResponse response, String title) throws IOException{
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");
	}
	

	static void produceHTMLPageContinue(RequestStatus status, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
//		Class<? extends RequestStatus> klass = status.getClass();
//		if (klass.equals(???))
		
		out.println("<p>" + status.getStatusString() + "</p>");
	}
	
	static void produceHTMLPage(RequestStatus status, HttpServletResponse response, String title) throws IOException{
		produceHTMLPageBegin(response, title);
		produceHTMLPageContinue(status, response);
		produceHTMLPageEnd(response);
	}
	
	static void produceHTMLPageEnd(HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		out.println("</body>");
		out.println("</html>");
	}
}
