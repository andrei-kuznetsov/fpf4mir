package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import javax.ws.rs.core.MultivaluedMap;
import javax.xml.bind.DatatypeConverter;

public class Authenticator implements ClientRequestFilter {
	private final String authLine;

	public Authenticator(String user, String password) {
		this.authLine = getBasicAuthentication(user, password);
	}

	public Authenticator(String authLine) {
		this.authLine = "BASIC " + authLine;
	}
	
	public void filter(ClientRequestContext requestContext) throws IOException {
		MultivaluedMap<String, Object> headers = requestContext.getHeaders();
		headers.add("Authorization", authLine);

	}

	private static String getBasicAuthentication(String user, String password) {
		String token = user + ":" + password;
		try {
			return "BASIC "
					+ DatatypeConverter.printBase64Binary(token
							.getBytes("UTF-8"));
		} catch (UnsupportedEncodingException ex) {
			throw new IllegalStateException("Cannot encode with UTF-8", ex);
		}
	}
}
