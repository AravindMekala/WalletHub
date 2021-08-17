package com.facebook.selenium.commons;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.facebook.selenium.commons.ApplicationConfiguration;

public class ApplicationConfiguration {
	private static Logger log = LoggerFactory.getLogger(ApplicationConfiguration.class);
	
	 private static PropertiesConfiguration properties;
	 
	 //This class is to read values from properties file.
	 public static String get(String key){
	        if(properties == null){
	            properties = new PropertiesConfiguration();
	            PropertiesConfiguration applicationProperties = null;
	            
	            
	            try {
	                applicationProperties = new PropertiesConfiguration();
	                applicationProperties.load(ClassLoader.getSystemResourceAsStream("config/app.properties"));
	            } catch (ConfigurationException e) {
	            	
	                log.error("could not read application property file");
	            }
	            properties.append(applicationProperties);
	        }
	        return properties.getString(key);
	 }
	 public static boolean getBoolean(String key){
	        return Boolean.parseBoolean(get(key));
	    }
	  public static int getInteger(String key){
	        return Integer.parseInt(get(key));
	    }
}
