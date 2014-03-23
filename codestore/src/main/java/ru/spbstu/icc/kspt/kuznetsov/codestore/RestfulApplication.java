package ru.spbstu.icc.kspt.kuznetsov.codestore;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath(value="/codestore")
public class RestfulApplication  extends Application{

	private Set<Object> singletons = new HashSet<Object>();
	private Set<Class<?>> classes = new HashSet<Class<?>>();

	public RestfulApplication() {
		// ADD YOUR RESTFUL RESOURCES HERE
//		this.singletons.add(new DatabaseService());
		this.classes.add(SubmissionService.class);
	}

	public Set<Class<?>> getClasses() {
		return this.classes;
	}

	public Set<Object> getSingletons() {
		return this.singletons;
	}
}
