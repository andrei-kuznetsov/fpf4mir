package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest;

import javax.ejb.Local;
import javax.ws.rs.core.Response;

@Local
public interface OORestFacade {

	public abstract Response addCartridgeByName(String addId, String cartName);

	public abstract Response addCartridgeByUrl(String addId, String url);

	public abstract Response deleteCartridgeByName(String addId, String cartName);

	public abstract void close();

	public abstract void init(String host, int port, String authLine,
			boolean doSslVerification);

}