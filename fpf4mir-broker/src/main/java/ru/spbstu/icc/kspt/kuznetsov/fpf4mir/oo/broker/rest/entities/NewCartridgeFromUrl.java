package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.entities;

public class NewCartridgeFromUrl {
	private String url;

	public NewCartridgeFromUrl(String url) {
		this.url = url;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}
}
