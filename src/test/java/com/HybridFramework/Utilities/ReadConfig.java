package com.HybridFramework.Utilities;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ReadConfig 
{
	Properties pro;
	
	// Create Constructor
	public ReadConfig()
	{
		File src = new File("./Configuration/config.properties");
		try{
		FileInputStream fis = new FileInputStream(src);
		pro = new Properties();
		pro.load(fis); // load is a method which load the complete file
		}catch (Exception e) {
		System.out.println("Exception is " + e.getMessage());
		}
	}
	
	// Create different methods for each properties value, just like a PageObject Class
	public String getApplicationURL()
	{
		String url = pro.getProperty("baseURL");
		return url;
	}
	public String getUsername()
	{
		String username = pro.getProperty("username");
		return username;
	}
	public String getPassword()
	{
		String password = pro.getProperty("password");
		return password;
	}
	public String getChromePath()
	{
		String chromepath = pro.getProperty("chromepath");
		return chromepath;
	}
	public String getFirefoxPath()
	{
		String firefox = pro.getProperty("firefoxpath");
		return firefox;
	}
	public String getEdgePath()
	{
		String edgepath = pro.getProperty("edgepath");
		return edgepath;
	}
}
