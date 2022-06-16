package com.qa.Hooks;

import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.qa.ConfigurationReader.configReader;
import com.qa.Factory.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class AppHooks {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private configReader config;

	Properties prop;

	@Before(order = 0)
	public void getProperty() {
		config = new configReader();
		 prop = config.setProperties();

	}

	@Before(order = 1)
	public void launchBrowser() {
		String browserName = prop.getProperty("browser");
		driverFactory = new DriverFactory();
		driver = driverFactory.initialiseBrowser(browserName);
	}

	/*@After(order = 0)
	public void quitBrowser() {
		driver.close();
		driver.quit();
	}*/

	/*@After(order = 1)
	public void tearDown(Scenario sc) throws InterruptedException {
		if(sc.isFailed())
		{
			//take screen shot
			String screenshotName = sc.getName().replaceAll(" ", "_");
			byte[] sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(sourcePath, "image/png", screenshotName);

		}
		Thread.sleep(3000);
	
	}*/
}
