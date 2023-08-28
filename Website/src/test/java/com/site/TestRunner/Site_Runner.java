package com.site.TestRunner;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

import com.baseClass.BaseClass;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src//test//resources//Features", glue = "com.site.StepDefinitions", monochrome = true, dryRun = false, strict = true, plugin = {
		"pretty", "html:target/Test Report/Html Report/Report", "json:target/Test Report/Json Report/Report.json", "junit:target/Test Report/JUnit Report/Report.xml"})

public class Site_Runner {

	public static WebDriver driver;

	@BeforeClass
	public static void set_Up() {
		driver = BaseClass.openBrowser("firefox");
	}

	@AfterClass
	public static void tear_Down() {
		driver.quit();
	}
}
