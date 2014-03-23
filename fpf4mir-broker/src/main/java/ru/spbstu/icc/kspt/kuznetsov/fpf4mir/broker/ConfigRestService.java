package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.broker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.logging.Logger;

import javax.ejb.EJB;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.OORestFacade;

@Path("/v1")
public class ConfigRestService {
	Logger log = Logger.getLogger(ConfigRestService.class.getName());
	
	private FeaturesService features = new FeaturesServiceImpl();
	
	
	@EJB
	private OORestFacade ooFacade;
	
	@POST
	@Path("/add/application/{appId}/feature/{feature}")
	public Response addFeatureToApp(@PathParam("appId") String appId,
			@PathParam("feature") String featureName) {

		URL url = features.getUrlForFeature(featureName);
		if (url == null){
			return Response.status(Status.BAD_REQUEST)
					.entity("Feature not found: " + featureName).build();
		} else {
			return ooFacade.addCartridgeByUrl(appId, url.toString());
		}
	}

	@POST
	@Path("/add/feature/{feature}")
	public Response addFeature(@PathParam("feature") String featureName,
			@QueryParam("url") String cartUrl) {
		if (cartUrl == null) {
			return Response.status(Status.BAD_REQUEST)
					.entity("Query parameter 'url' is required.").build();
		} else {
			URL url;
			try {
				url = new URL(cartUrl);
			} catch (MalformedURLException e) {
				log.fine("Failed to parse URL:" + e.getMessage());
				return Response.status(Status.BAD_REQUEST)
						.entity("Invalid cartridge URL:" + e.getMessage()).build();
			}
			
			features.addFeature(featureName, url);
			return Response.ok().build();
		}
	}
}
