package com.qa.ConfigurationReader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class configReader {
	
	 Properties prop;
	 FileInputStream fis;
	
	public Properties setProperties()
	{
		try {
		 fis = new FileInputStream(".//src//resources//java//com//qa//Configuration//config.properties");
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound : Check properties file path");
			e.printStackTrace();
		}
		prop = new Properties();
		try {
			prop.load(fis);
		} catch (IOException e) {
			System.out.println("File cannot be accessed : Please check if file is corrupted");
			e.printStackTrace();
		}
		return prop;
	
		
	}
	

}
