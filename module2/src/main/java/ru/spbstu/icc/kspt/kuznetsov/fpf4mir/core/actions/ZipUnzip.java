package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.core.actions;


import java.io.File;

import net.lingala.zip4j.core.ZipFile;
import net.lingala.zip4j.exception.ZipException;

public class ZipUnzip {
	public static void unzip(File source, String destination, String password){

	    try {
	         ZipFile zipFile = new ZipFile(source);
	         if (password != null && zipFile.isEncrypted()) {
	            zipFile.setPassword(password);
	         }
	         zipFile.extractAll(destination);
	    } catch (ZipException e) {
			e.printStackTrace();
		}
	}
	
	public static void unzip(File source, String destination){
		unzip(source, destination, null);
	}
}
