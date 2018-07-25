package com.rafaelximenes.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ReadProperties {
	public static String readElement(String key) {
		String diretorio = "";
		String resourceName = "application.properties"; // could also be a
															// constant
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Properties props = new Properties();
		InputStream resourceStream = loader.getResourceAsStream(resourceName);
		try {
			props.load(resourceStream);
			diretorio = props.getProperty(key);
			return diretorio;
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
		
	}
}
