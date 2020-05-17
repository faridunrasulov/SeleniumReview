package com.java.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigsRead {
	
	public static Properties prop;
	/**
	 * this method will read properties file 
	 * @param filePath
	 */
	
	public static void readProperties(String filePath) {
		try {
			FileInputStream file = new FileInputStream(filePath);
		    prop = new Properties();
			prop.load(file);
			file.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * this method will return a specified key
	 * @param  String key
	 * @return String value
	 */
	public static String getProperty(String key) {
		return prop.getProperty(key);
	}

}
