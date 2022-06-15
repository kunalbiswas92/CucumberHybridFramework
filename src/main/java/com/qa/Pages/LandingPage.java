package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	WebDriver driver ;
	String ActualTitle;
	private By pageLogo = By.xpath("//*[@id='header_logo'");
	private By signInLink = By.xpath("//a[@title='Log in to your customer account']");
	
	public LandingPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public String getTitle()
	{
		 ActualTitle = driver.getTitle();
		 return ActualTitle;
	}
	
	public boolean isSignInButtonVisible()
	{
		boolean isSignInLinkDisplayed = driver.findElement(signInLink).isDisplayed();
		return isSignInLinkDisplayed;
	}
	
	public void clickOnSignInlink() throws InterruptedException
	{
		driver.findElement(signInLink).click();
		Thread.sleep(2000);
	}
		

}
