package com.tcWebsite;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.baseClass.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Tc_Website extends BaseClass {

	public static WebDriver driver = BaseClass.openBrowser("firefox");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Tc_Website.class);

	public static void main(String[] args) throws Throwable {

		//public void website() throws Throwable{
		
		PropertyConfigurator.configure("log4j.properties");

		log.info("Browser Launch");

		getUrl("https://tcfoodapp.sumanas.xyz/login");
		implicitwait();

		String url = driver.getCurrentUrl();
		Assert.assertTrue(url.contains("https://tcfoodapp.sumanas.xyz/login"));

		log.info("Login");

		String email = FileReaderManager.getInstanceFRM().getInstanceCR().getEmail();
		sendkeys(pom.getInstanceli().getUsername(), email);

		String password = FileReaderManager.getInstanceFRM().getInstanceCR().getPassword();
		sendkeys(pom.getInstanceli().getPassword(), password);

		clickon(pom.getInstanceli().getSignin());

		log.info("Dashboard");

		click(pom.getInstancedb().getSettings());
		staticwait();

		click(pom.getInstancedb().getCanteens());
		staticwait();

		log.info("Canteen List");

		clickonelement(pom.getInstancecl().getCreate());
		staticwait();

		log.info("Add New Canteen");

		sendkeys(pom.getInstancenc().getCanteenname(), "ST Canteen");

		sendkeys(pom.getInstancenc().getCanteencode(), "C");

		clickonelement(pom.getInstancenc().getSubmit());
		staticwait();

		log.info("Search Canteen");

		clickonelement(pom.getInstancecl().getDismiss());

		sendkeys(pom.getInstancecl().getSearch(), "ST Canteen");
		staticwait();

		String search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']")).getText();
		System.out.println(search);
		Assert.assertEquals("ST Canteen", search);
		staticwait();

		log.info("Edit Canteen");

		clickonelement(pom.getInstancecl().getUpdate());
		staticwait();

		clear(pom.getInstancenc().getCanteenname());

		sendkeys(pom.getInstancenc().getCanteenname(), "Canteen");
		staticwait();

		clickonelement(pom.getInstancenc().getSubmit());
		staticwait();

		log.info("Delete Canteen");

		clickonelement(pom.getInstancecl().getDismiss());

		clear(pom.getInstancecl().getSearch());
		staticwait();

		clickonelement(pom.getInstancecl().getRefresh());
		staticwait();

		clickonelement(pom.getInstancecl().getDelete());
		staticwait();

		clickonelement(pom.getInstancecl().getDeleteit());

		clickonelement(pom.getInstancecl().getOk());
		staticwait();

		log.info("Logout");

		clickonelement(pom.getInstancelo().getAdmin());
		staticwait();

		clickonelement(pom.getInstancelo().getLogout());
		staticwait();

		driver.quit();

	}

}
