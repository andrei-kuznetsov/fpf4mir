package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.broker;

import java.net.URL;

import javax.ejb.Local;

@Local
public interface FeaturesService {
	public void addFeature(String feature, URL url);
	public URL getUrlForFeature(String feature) ;
}
