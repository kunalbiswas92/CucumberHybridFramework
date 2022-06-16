package com.qa.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	WebDriver driver;

	private By emailTxtField = By.xpath("//*[@id='email']");
	private By passwordTxtField = By.xpath("//*[@id='passwd']");
	private By signInButton = By.xpath("//button[@id='SubmitLogin']/span");

	public LoginPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public String  verifyLoginPageTitle()
	{
		String actualTitle = driver.getTitle();
		return actualTitle;
	}
	
	public AccountsPage enterLoginCredentials(String username , String password) throws InterruptedException
	{
		driver.findElement(emailTxtField).sendKeys(username);
		driver.findElement(passwordTxtField).sendKeys(password);
		driver.findElement(signInButton).click();
		Thread.sleep(4000);
		return new AccountsPage(driver);
	}

}
