package com.qa.Pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountsPage {
	private By PersonalInfoSections = By.xpath("//ul[@class='myaccount-link-list']/li/a/span");
	
	WebDriver driver;
	ArrayList<String> arr1;
	public AccountsPage(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifySections(List sections)
	{
		arr1 = new ArrayList<String>();
		boolean match = false;
		System.out.println(sections);
		List<WebElement> listOfOptions = driver.findElements(PersonalInfoSections);
		for(WebElement i : listOfOptions)
		{
			String textOptions = i.getText();
			arr1.add(textOptions);
			
		}
		if(arr1.containsAll(sections))
		{
			match = true;
		}
		
		System.out.println(arr1);
		return match;
	}
	
	public String verifyAccountPageTitle()
	{
		return driver.getTitle();
	}
	
	
	
}
