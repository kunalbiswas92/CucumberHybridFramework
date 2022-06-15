package com.qa.Factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
	
	
	public WebDriver driver;
	
	public static ThreadLocal<WebDriver> tl= new ThreadLocal<WebDriver>();
	
	public WebDriver initialiseBrowser(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			tl.set(new ChromeDriver());
		}
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			tl.set(new FirefoxDriver());
		}
		if(browser.equalsIgnoreCase("IE"))
		{
			WebDriverManager.iedriver().setup();
			tl.set(new InternetExplorerDriver());
		}
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		return driver;
		
	}
	
	public static synchronized WebDriver getDriver()
	{
		WebDriver tlDriver = tl.get();
		return tlDriver;
	}
	

}
