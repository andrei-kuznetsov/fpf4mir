package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.DeploymentSession.QResult;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.facts.Activity;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatus;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.requestfacts.RequestSubstatusActivityLog;

public class HTMLProducer {

	static void produceHTMLPageBegin(HttpServletResponse response, String title) throws IOException{
		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<title>" + title + "</title>");
		out.println("</head>");
		out.println("<body>");
	}
	
	static void produceHTMLPageContinue(List<QResult> status, HttpServletResponse response) throws IOException{
		for (QResult i : status){
			produceHTMLPageContinue(i, response);
			response.getWriter().println("<br><hr><br>");
		}
	}

	static void produceHTMLPageContinue(QResult status, HttpServletResponse response) throws IOException{
		PrintWriter out = response.getWriter();
		
//		Class<? extends RequestStatus> klass = status.getClass();
//		if (klass.equals(???))
		
		out.println("<p>" + status.mainStatus.getMessage() + "</p>");
		out.println("<p>" + status.mainStatus.toString() + "</p>");
		for (RequestSubstatus i : status.substatuses){
			if (i instanceof RequestSubstatusActivityLog){
				for (Activity a : ((RequestSubstatusActivityLog)i).getActivities()){
					out.println("<p>" + a.toString() + "</p>");
				}
			} else {
				out.println("<p>" + i.toString() + "</p>");
			}
		}
	}
	
	static void produceHTMLPage(List<QResult> status, HttpServletResponse response, String title) throws IOException{
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
