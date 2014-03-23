package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Ignore;
import org.junit.Test;

import ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.OORestFacadeImpl;

public class OORestFacadeTest {
	private static final int OO_PORT = 443;
	private static final String OO_HOST = "broker-a2dc6f.openshift.local";
	private static final String AUTH_LINE = "ZGVtbzpjaGFuZ2VtZQ==";
	private static final String appId = "532d689344b3be836800000e";
	
	@Test
	@Ignore
	public void testAddCartridge() {
		OORestFacade facade = new OORestFacadeImpl(OO_HOST, OO_PORT, AUTH_LINE, false);
		Response response = facade.addCartridgeByUrl(appId, "http://192.168.1.2/openshift-nginx-cartridge-master/metadata/manifest.yml");
		System.out.println(response.readEntity(String.class));
		assertEquals(201, response.getStatus());
		facade.close();
	}

	@Test
	public void testDeleteCartridge() {
		OORestFacade facade = new OORestFacadeImpl(OO_HOST, OO_PORT, AUTH_LINE, false);
		Response response = facade.deleteCartridgeByName(appId, "andrei_kuznetsov-maven-3.0.5");
		System.out.println(response.readEntity(String.class));
		assertEquals(200, response.getStatus());
		facade.close();
	}
}
