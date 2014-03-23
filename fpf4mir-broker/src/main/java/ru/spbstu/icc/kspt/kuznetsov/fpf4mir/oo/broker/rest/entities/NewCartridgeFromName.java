package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.oo.broker.rest.entities;

public class NewCartridgeFromName {
	private String name;

	public NewCartridgeFromName(String url) {
		this.name = url;
	}

	public String getUrl() {
		return name;
	}

	public void setUrl(String url) {
		this.name = url;
	}
}
