package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import javax.ws.rs.core.Application;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.jboss.resteasy.plugins.server.servlet.HttpServletDispatcher;

public class HttpMain {
	private static final Logger log = Logger.getLogger(HttpMain.class);

	public static void main(String[] args) throws Exception {
		log.setLevel(Level.ALL);

		Server server = new Server(8080);
		// server.setHandler(new HttpMain());
		ServletContextHandler context = new ServletContextHandler(
				ServletContextHandler.SESSIONS);
		context.setContextPath("/");
		ServletHolder h = new ServletHolder(new HttpServletDispatcher());
		h.setInitParameter(Application.class.getCanonicalName(),
				RESTService.class.getCanonicalName());
		context.addServlet(h, "/*");
		server.setHandler(context);

		server.start();
		server.join();
	}
}
