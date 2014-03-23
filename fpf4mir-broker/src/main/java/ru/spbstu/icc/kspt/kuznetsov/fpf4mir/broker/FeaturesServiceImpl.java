package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.broker;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.ejb.Stateless;

@Stateless
public class FeaturesServiceImpl implements FeaturesService{

	private static final ConcurrentMap<String, URL> map = new ConcurrentHashMap<String, URL>();
	
	public FeaturesServiceImpl() {
		// TODO Auto-generated constructor stub
		try {
			map.put("maven-3.0.5", new URL("http://192.168.1.2/openshift-nginx-cartridge-master/metadata/manifest305.yml"));
			map.put("maven-3.1.1", new URL("http://192.168.1.2/openshift-nginx-cartridge-master/metadata/manifest311.yml"));
			map.put("maven", new URL("http://192.168.1.2/openshift-nginx-cartridge-master/metadata/manifest311.yml"));
			map.put("xvfb", new URL("http://192.168.1.2/openshift-xvfb-cartridge-master/metadata/manifest.yml"));
			map.put("x-server", new URL("http://192.168.1.2/openshift-xvfb-cartridge-master/metadata/manifest.yml"));
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void addFeature(String feature, URL url) {
		map.put(feature, url);
	}

	@Override
	public URL getUrlForFeature(String feature) {
		URL url = map.get(feature);
		return url;
	}
	
}
