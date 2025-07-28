package com.pronoydas.utility;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class PropertyLoader {
	
	
	
	  private static final Logger log = (Logger) LoggerFactory.getLogger(PropertyLoader.class);
	  
	  private static Properties properties;
	  
	  
	  
	 
	
	
	public static void initialize(){
		
		

        // load default properties
        properties = loadProperties();

        // check for any override
        for(String key: properties.stringPropertyNames()){
            if(System.getProperties().containsKey(key)){
                properties.setProperty(key, System.getProperty(key));
            }
        }

        // print
        log.info("Test Properties");
        log.info("-----------------");
        for(String key: properties.stringPropertyNames()){
            log.info("{}={}", key, properties.getProperty(key));
        }
        log.info("-----------------");

    }

    private static Properties loadProperties(){
    	String filePath = String.format("Config%sapplicationConfig.properties", File.separator);
        Properties properties = new Properties();
        try(InputStream is=ResourceLoader.getResouce(filePath)){
            properties.load(is);
        }catch (Exception e){
            log.error("unable to read the property file {}", e);
        }
        return properties;
    }

	
	
	public static String getPropertyValue(String name) throws IOException {
		return properties.getProperty(name);
	}

}
