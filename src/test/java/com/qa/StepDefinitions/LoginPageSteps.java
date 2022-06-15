package com.qa.StepDefinitions;

import java.util.Properties;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import com.qa.ConfigurationReader.configReader;
import com.qa.Factory.DriverFactory;
import com.qa.Hooks.AppHooks;
import com.qa.Pages.LandingPage;
import com.qa.Pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginPageSteps {

	private DriverFactory driverFactory;
	private WebDriver driver;
	private configReader config;
	private AppHooks hooks;
	Properties prop;

	LandingPage landing = new LandingPage(DriverFactory.getDriver());
	LoginPage login = new LoginPage(DriverFactory.getDriver());

	@Given("user lanches the application URL")
	public void user_lanches_the_application_url() {

		DriverFactory.getDriver().get("http://automationpractice.com/index.php");
	}

	@Given("lands on home page with title {string}")
	public void lands_on_home_page_with_title(String ExpectedString) {
		String ActualTitle = landing.getTitle();
		Assert.assertEquals(ExpectedString, ActualTitle);
	}

	@Then("user should be able to see the sign in button on home page")
	public void user_should_be_able_to_see_the_sign_in_button_on_home_page() {

		Assert.assertTrue(landing.isSignInButtonVisible());
	}

	@When("user clicks on sign in button on home page")
	public void user_clicks_on_sign_in_button_on_home_page() {
		try {
			landing.clickOnSignInlink();
		} catch (InterruptedException e) {
			System.out.println("Element is not found");
			e.printStackTrace();
		}
	}

	@When("is directed to the login page with title {string}")
	public void is_directed_to_the_login_page_with_title(String ExpectedString) {
		String title = login.verifyLoginPageTitle();
		Assert.assertEquals(ExpectedString, title);
	}

	@Then("^user enters the correct username \"([^\"]*)\" and password \"([^\"]*)\"$")
	public void user_enters_the_correct_username_something_and_password_something(String username, String password)
			throws Throwable {
		
		login.enterLoginCredentials(username, password);
	}

	@Then("^logs into the account with page title \"([^\"]*)\"$")
	public void logs_into_the_account_with_page_title_something(String ExpectedString) throws Throwable {
		String title = login.verifyLoginPageTitle();
		Assert.assertEquals(ExpectedString, title);
	}

}
