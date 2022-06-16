package com.qa.StepDefinitions;

import java.util.List;

import org.junit.Assert;

import com.qa.Factory.DriverFactory;
import com.qa.Pages.AccountsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class AccountPageSteps {

	AccountsPage account = new AccountsPage(DriverFactory.getDriver());

	@Then("^user should get the personal information section with below links$")
	public void user_should_get_the_personal_information_section_with_below_links(DataTable datatable) {
		List<List<String>> sections = datatable.asList(String.class);
		boolean match = account.verifySections(sections);
		Assert.assertTrue(match);
	}
}
