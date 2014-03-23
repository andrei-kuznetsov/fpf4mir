package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.cert.X509Certificate;

import javax.ejb.Stateful;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.entities.NewCartridgeFromName;
import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.entities.NewCartridgeFromUrl;

@Stateful
public class OORestFacadeImpl implements OORestFacade {
	private Client ooClient;
	private WebTarget ooBase;
	private WebTarget ooApplication;

	public OORestFacadeImpl() {
	}
	
	public OORestFacadeImpl(String host) {
		this(host, 443, "ZGVtbzpjaGFuZ2VtZQ==" /*"demo:changeme"*/, true); 
	}

	public OORestFacadeImpl(String host, int port, String authLine, boolean doSslVerification) {
		this.init(host, port, authLine, doSslVerification);
	}
	
	@Override
	public void init(String host, int port, String authLine, boolean doSslVerification) {
		ooClient = ClientBuilder.newClient();
		
		if (!doSslVerification){
		    // Create a trust manager that does not validate certificate chains
		    final TrustManager[] trustAllCerts = new TrustManager[] { new X509TrustManager() {
		        @Override
		        public void checkClientTrusted( final X509Certificate[] chain, final String authType ) {
		        }
		        @Override
		        public void checkServerTrusted( final X509Certificate[] chain, final String authType ) {
		        }
		        @Override
		        public X509Certificate[] getAcceptedIssuers() {
		            return null;
		        }
		    } };
		    
			try {
				ooClient.getSslContext().init(null, trustAllCerts, new java.security.SecureRandom());
			} catch (KeyManagementException e) {
				e.printStackTrace();
			}
		}
		
		ooClient.register(new Authenticator(authLine));
		URI builder = UriBuilder.fromPath("https://{host}:{port}/broker/rest/")
				.build(host, port);

		ooBase = ooClient.target(builder);
		ooApplication = ooBase.path("application");
	}

	private Response addCartridge(String addId, Entity entity) {
		Response resp = ooApplication.path(addId).path("cartridges")
				.request(MediaType.APPLICATION_JSON).post(entity);
		return resp;
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.OORestFacade#addCartridgeByName(java.lang.String, java.lang.String)
	 */
	@Override
	public Response addCartridgeByName(String addId, String cartName) {
		return addCartridge(addId,
				Entity.json(new NewCartridgeFromName(cartName)));
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.OORestFacade#addCartridgeByUrl(java.lang.String, java.lang.String)
	 */
	@Override
	public Response addCartridgeByUrl(String addId, String url) {
		return addCartridge(addId, Entity.json(new NewCartridgeFromUrl(url)));
	}

	/* (non-Javadoc)
	 * @see ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.OORestFacade#deleteCartridgeByName(java.lang.String, java.lang.String)
	 */
	@Override
	public Response deleteCartridgeByName(String addId, String cartName) {
		Response resp = ooApplication.path(addId).path("cartridge")
				.path(cartName).request(MediaType.APPLICATION_JSON).delete();
		return resp;
	}

	@Override
	public void close() {
		ooClient.close();
	}
}
