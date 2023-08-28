package com.tcWebsite;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.baseClass.BaseClass;
import com.helper.FileReaderManager;
import com.helper.PageObjectManager;

public class Tc_Site extends BaseClass {

	public static WebDriver driver = BaseClass.openBrowser("firefox");
	public static PageObjectManager pom = new PageObjectManager(driver);
	public static Logger log = Logger.getLogger(Tc_Site.class);

	public static void main(String[] args) throws Throwable {

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

		click(driver.findElement(By.xpath("//span[normalize-space()='Settings']")));
		staticwait();
		click(driver.findElement(By.xpath("//span[normalize-space()='Canteens']")));
		staticwait();

		log.info("Canteen List");

		click(driver.findElement(By.xpath("//button[normalize-space()='New']")));
		staticwait();

		log.info("Add New Canteen");

		driver.findElement(By.id("canteen")).sendKeys("ST Canteen");
		driver.findElement(By.id("short_code")).sendKeys("C");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		staticwait();

		log.info("Search Canteen");

		driver.findElement(By.xpath("//button[@data-bs-dismiss='alert']")).click();
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys("ST Canteen");
		staticwait();

		String search = driver.findElement(By.xpath("//td[@class='fw-bold sorting_1']")).getText();
		System.out.println(search);
		Assert.assertEquals("ST Canteen", search);
		staticwait();

		log.info("Edit Canteen");

		driver.findElement(By.xpath("//a[@class='btn btn-primary btn-sm mr-1']")).click();
		staticwait();

		driver.findElement(By.id("canteen")).clear();
		driver.findElement(By.id("canteen")).sendKeys("Canteen");
		staticwait();
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		staticwait();

		log.info("Delete Canteen");

		driver.findElement(By.xpath("//button[@data-bs-dismiss='alert']")).click();

		driver.findElement(By.xpath("//input[@type='search']")).clear();
		staticwait();
		driver.findElement(By.xpath("//i[@class='bi bi-arrow-counterclockwise']")).click();
		staticwait();

		driver.findElement(By.xpath("(//button[@class='btn btn-danger btn-delete btn-sm mr-1'])[1]")).click();
		staticwait();

		driver.findElement(By.xpath("//button[normalize-space()='Yes, delete it!']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='OK']")).click();
		staticwait();

		log.info("Logout");

		driver.findElement(By.xpath("//strong[@class='d-md-inline-block d-none']")).click();
		staticwait();
		driver.findElement(By.xpath("//a[normalize-space()='Log Out']")).click();
		staticwait();

		driver.quit();

	}

}
