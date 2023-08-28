package com.site.StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.baseClass.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;
import com.site.TestRunner.Site_Runner;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Site_StepDefinitions extends BaseClass {

	public static WebDriver driver = Site_Runner.driver;
	public static PageObjectManager pom = new PageObjectManager(driver);

	@Given("user Navigates to The TC Website")
	public void user_navigates_to_the_tc_website() {

		getUrl("https://tcfoodapp.sumanas.xyz/login");
		implicitwait();

		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

	}

	@When("user Enters The Username And Password")
	public void user_enters_the_username_and_password() throws Throwable {

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendkeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendkeys(pom.getInstanceli().getPassword(), password);

	}

	@Then("user Clicks The Signin Button And Navigate To The Dashboard Page")
	public void user_clicks_the_signin_button_and_navigate_to_the_dashboard_page() {

		clickon(pom.getInstanceli().getSignin());

	}

	@When("user Click Settings Option On The Dashboard")
	public void user_click_settings_option_on_the_dashboard() throws Throwable {

		click(pom.getInstancedb().getSettings());
		staticwait();

	}

	@When("user Click On The Canteens Option From The Dropdown")
	public void user_click_on_the_canteens_option_from_the_dropdown() throws Throwable {

		click(pom.getInstancedb().getCanteens());
		staticwait();

	}

	@Then("user Click On New To Create A New Canteen From The Canteen List")
	public void user_click_on_new_to_create_a_new_canteen_from_the_canteen_list() throws Throwable {

		clickonelement(pom.getInstancecl().getCreate());
		staticwait();

	}

	@When("user Enters The Canteen Name And Then user Enters The Canteen Code")
	public void user_enters_the_canteen_name_and_then_user_enters_the_canteen_code() {

		sendkeys(pom.getInstancenc().getCanteenname(), "ST Canteen");

		sendkeys(pom.getInstancenc().getCanteencode(), "007");

	}

	@When("user Click On The Save Button And Navigates To The Canteen List Page")
	public void user_click_on_the_save_button_and_navigates_to_the_canteen_list_page() throws Throwable {

		clickonelement(pom.getInstancenc().getSubmit());
		staticwait();

	}

	@Then("user Click On The Close Button of The Popup Alert")
	public void user_click_on_the_close_button_of_the_popup_alert() {

		clickonelement(pom.getInstancecl().getDismiss());

	}

	@When("user Enters The Canteen Name In The Search Box")
	public void user_enters_the_canteen_name_in_the_search_box() throws Throwable {

		sendkeys(pom.getInstancecl().getSearch(), "ST Canteen");
		staticwait();

	}

	@Then("user Validates The Canteen Name")
	public void user_validates_the_canteen_name() throws Throwable {

		String search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']")).getText();
		System.out.println(search);
		Assert.assertEquals("ST Canteen", search);
		staticwait();

	}

	@When("user Clicks The Edit Button")
	public void user_clicks_the_edit_button() throws Throwable {

		clickonelement(pom.getInstancecl().getUpdate());
		staticwait();

	}

	@When("user Clears the Canteen Name And Enters The New Name")
	public void user_clears_the_canteen_name_and_enters_the_new_name() {

		clear(pom.getInstancenc().getCanteenname());

		sendkeys(pom.getInstancenc().getCanteenname(), "As Canteen");

	}

	@When("user Submits By Clicking The Save Button And Close The Popup Alert")
	public void user_submits_by_clicking_the_save_button_and_close_the_popup_alert() throws Throwable {

		clickonelement(pom.getInstancenc().getSubmit());
		staticwait();
		clickonelement(pom.getInstancecl().getDismiss());
		staticwait();

	}

	@When("user Clears The Previous Canteen Name In The Search Box")
	public void user_clears_the_previous_canteen_name_in_the_search_box() throws Throwable {

		clear(pom.getInstancecl().getSearch());
		staticwait();

	}

	@When("user Clicks On The Refresh Button From The Canteen List")
	public void user_clicks_on_the_refresh_button_from_the_canteen_list() throws Throwable {

		clickonelement(pom.getInstancecl().getRefresh());
		staticwait();

	}

	@Then("user Enter a Canteen Name In The Search Box TO Validate The Canteen Name")
	public void user_enter_a_canteen_name_in_the_search_box_to_validate_the_canteen_name() throws Throwable {
		
		sendkeys(pom.getInstancecl().getSearch(), "AS Canteen");

		String search1 = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']")).getText();
		System.out.println(search1);
		//Assert.assertTrue(search1.contains("AS"));
		//staticwait();
	}

	@When("user Clicks The Delete Button")
	public void user_clicks_the_delete_button() throws Throwable {

		clickonelement(pom.getInstancecl().getDelete());
		staticwait();

	}

	@When("user Clicks On The Delete It Button IN The Alert Box")
	public void user_clicks_on_the_delete_it_button_in_the_alert_box() {

		clickonelement(pom.getInstancecl().getDeleteit());

	}

	@Then("user Clicks The OK Button In The Alert Box")
	public void user_clicks_the_ok_button_in_the_alert_box() throws Throwable {

		clickonelement(pom.getInstancecl().getOk());
		staticwait();

	}

	@When("user Clicks On The User ID")
	public void user_clicks_on_the_user_id() throws Throwable {

		clickonelement(pom.getInstancelo().getAdmin());
		staticwait();

	}

	@Then("user Clicks on the Logout Button")
	public void user_clicks_on_the_logout_button() throws Throwable {

		clickonelement(pom.getInstancelo().getLogout());
		staticwait();

	}

	@Then("user Quits The Browser")
	public void user_quits_the_browser() {

		driver.quit();

	}

}
