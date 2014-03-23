package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.broker;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

/**
 * Since we're not using a jax-rs servlet mapping, we must define an Application
 * class that is annotated with the @ApplicationPath annotation. If you return
 * any empty set for by classes and singletons, your WAR will be scanned for
 * JAX-RS annotation resource and provider classes.
 * 
 * @author andrei
 * 
 */
@ApplicationPath("/rest/api")
public class ResteasyApplication extends Application{

}
