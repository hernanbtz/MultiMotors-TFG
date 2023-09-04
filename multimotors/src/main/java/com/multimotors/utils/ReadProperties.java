package com.multimotors.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;

/**
 * @author Fabian
 * @author Sergio
 */
public class ReadProperties {
    
    private final HashMap<String, String> hmProperties;
    private final java.util.Properties properties;
    private final String filePath;
    
    public ReadProperties(String ppt_filename) {
	hmProperties = new HashMap<>();
	properties = new java.util.Properties();
	this.filePath = ppt_filename;
	loadFile();
    }
    
    private void loadFile(){        
        try {
            try (InputStream is = new FileInputStream(this.filePath)) {
                properties.load(is);
                
                Enumeration<?> elem = properties.propertyNames();
                while (elem.hasMoreElements()) {
                    String key = (String) elem.nextElement();
                    String value = properties.getProperty(key);
                    hmProperties.put(key, value);
                }
            }         
        } catch (IOException ex) {
        }
    }
    
    public String getProperty(String ppt_name){
	return  hmProperties.get(ppt_name);
    }
}