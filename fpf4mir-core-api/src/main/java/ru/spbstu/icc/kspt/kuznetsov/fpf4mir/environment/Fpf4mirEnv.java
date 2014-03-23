package ru.spbstu.icc.kspt.kuznetsov.fpf4mir.environment;

import org.apache.log4j.Logger;


public class Fpf4mirEnv {
	private static final Logger log = Logger.getLogger(Fpf4mirEnv.class);
	
    public static String getVariableString(String envVar, String defValue) {
    	String strValue = System.getenv(envVar);
    	boolean success = false;
    	
    	if (strValue != null && !strValue.isEmpty()){
			success = true;
    	} else {
    		log.warn("Environment variable '" + envVar + "' hasn't been set.");
    	}

    	if (!success){
    		strValue = defValue;
    		log.warn("Use default value '" + envVar + "'=" + strValue);
    	}
    	
    	return strValue;
	}
    
    public static int getVariableInt(String envVar, int defValue) {
    	String strValue = getVariableString(envVar, String.valueOf(defValue));
    	
    	int intVal = 0;
    	boolean success = false;
    	
		try {
			intVal = Integer.parseInt(strValue);
			success = true;
		} catch (NumberFormatException e){
			log.error("Can't parse as integer (" + envVar + "=" + strValue + ").");
		}

    	if (!success){
    		intVal = defValue;
    		log.warn("Use default value '" + envVar + "'=" + intVal);
    	}
    	
    	return intVal;
	}
}
