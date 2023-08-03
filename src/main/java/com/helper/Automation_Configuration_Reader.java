package com.helper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class Automation_Configuration_Reader {
	
	public static Properties p;
	public Automation_Configuration_Reader() throws Throwable {
		File f = new File("C:\\Users\\Ahmad\\Desktop\\Amazon-Workspace\\Amazon_Ecommerce_Site\\Configuration Properties\\Login_Functionality.properties");
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