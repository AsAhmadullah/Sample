package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigurationReader {
	
	public static Properties p;
	public ConfigurationReader() throws Throwable {
		File f = new File("//home//st//eclipse-workspace//ThiagarajarCollegeWebsite//Configuration Properties//Login Functionality.properties");
		FileInputStream fis = new FileInputStream(f);
		p = new Properties();
		p.load(fis);
	}
	
	public String geturl() {
		String url = p.getProperty("url");
		return url;
	}
	
	public String getEmail() {
		String email = p.getProperty("email");
		return email;
	}
	
	public String getPassword() {
		String password = p.getProperty("password");
		return password;
	}

}
