package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.net.InetSocketAddress;
import java.net.URL;

import javax.ws.rs.core.Application;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class HttpMain {
	private static final Logger log = Logger.getLogger(HttpMain.class);

	public static void main(String[] args) throws Exception {
		log.setLevel(Level.ALL);
		
		final URL warUrl = HttpMain.class.getClassLoader().getResource("webapp/");

		String host = System.getenv("OPENSHIFT_DIY_IP");
		String port = System.getenv("OPENSHIFT_DIY_PORT");
		InetSocketAddress bindAddress = InetSocketAddress.createUnresolved(host==null?"0.0.0.0":host, port==null?8080:Integer.parseInt(port));
		Server server = new Server(bindAddress);
		
		ServletContextHandler context = new WebAppContext(warUrl.toString(), "/");
		context.setInitParameter("cacheControl","max-age=0,public");
		
		ServletHolder h = new ServletHolder(new HttpServletDispatcher());
		h.setInitParameter(Application.class.getCanonicalName(), RESTService.class.getCanonicalName());
		context.addServlet(h, "/rest/*");
		
		context.addServlet(new ServletHolder(new KBServlet()), "/kb/*");
		
		server.setHandler(context);

		server.start();
		server.join();
	}
}
