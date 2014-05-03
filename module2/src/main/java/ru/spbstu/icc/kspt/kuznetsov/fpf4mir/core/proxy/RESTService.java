package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.proxy;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

public class RESTService extends Application {
	private static Set services = new HashSet();

	public RESTService() {
		// initialize restful services
		services.add(new Index());
	}

	@Override
	public Set getSingletons() {
		return services;
	}

	public static Set getServices() {
		return services;
	}
}
