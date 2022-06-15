package com.qa.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
	features = {"src/resources/java/com/qa/featureFiles"},
	glue = { "com.qa.StepDefinitions" ,"com.qa.Hooks"},
	plugin = {"pretty"}	,
	monochrome = true,
	publish=true,
	dryRun = false
	)

public class ApplicationTest {
	

}
