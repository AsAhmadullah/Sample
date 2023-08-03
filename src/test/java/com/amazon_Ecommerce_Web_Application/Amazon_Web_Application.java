package com.amazon_Ecommerce_Web_Application;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.ListIterator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.base_Class.BaseClass;
import com.helper.File_Reader_Manager;
import com.helper.Page_Object_Manager;

public class Amazon_Web_Application extends BaseClass {

	public static WebDriver driver = BaseClass.openBrowser("chrome");
	public static Page_Object_Manager pom = new Page_Object_Manager(driver);
	public static Logger log = Logger.getLogger(Amazon_Web_Application.class);

	// public static void main(String[] args) throws Throwable {
	@Test
	public void task() throws Throwable {

		PropertyConfigurator.configure("log4j.properties");

		log.info("Browser Launch");

		getUrl("https://www.amazon.in");
		implicitwait();

		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("https://www.amazon.in"));

		log.info("Login");

		click(pom.getInstanceli().getSignin());

		String email = File_Reader_Manager.getInstanceFRM().getInstanceACR().getEmail();
		sendkeys(pom.getInstanceli().getUsername(), email);

		clickonelement(pom.getInstanceli().getNext());

		String password = File_Reader_Manager.getInstanceFRM().getInstanceACR().getPassword();
		sendkeys(pom.getInstanceli().getPassword(), password);

		clickonelement(pom.getInstanceli().getLogin());

		log.info("Search Box");

		String expected = "Music";
		WebElement dropDown = driver.findElement(By.id("searchDropdownBox"));
		Select s = new Select(dropDown);
		List<WebElement> option = s.getOptions();
		ListIterator<WebElement> li = option.listIterator();
		while (li.hasNext()) {
			WebElement next = li.next();
			String actual = next.getText();
			if (actual.equalsIgnoreCase(expected)) {
				s.selectByVisibleText(actual);
				break;
			}
		}

		clickonelement(pom.getInstancesb().getSearchBox());

		sendkeys(pom.getInstancesb().getSearchBox(), "cd");

		clickon(pom.getInstancesb().getSubmit());

		log.info("Results Page");

		WebElement firstProduct = driver
				.findElement(By.xpath("//span[text()='Results']//ancestor::div[4]//following-sibling::div[1]//h2//a"));
		String firstProductText = firstProduct.getText();
		System.out.println(firstProductText);
		firstProduct.click();

		getwindowshandles();

		log.info("Product Page");

		WebElement selectProduct = driver.findElement(By.id("productTitle"));
		String selectedProductText = selectProduct.getText();
		System.out.println(selectedProductText);

		if (firstProductText.equals(selectedProductText)) {

			clickonelement(pom.getInstancepp().getAtcButton());

		}

		staticwait();

		log.info("ScreenShot");

		screenshot("/Amazon_Ecommerce_Site//Screenshot//AddToCart.png");

		staticwait();

		log.info("Add To Cart");

		click(pom.getInstanceatc().getGtcButton());

		log.info("Shopping Cart");

		WebElement cartProduct = driver
				.findElement(By.xpath("//span[@class='a-list-item']/parent::li[@class='a-spacing-mini']"));
		String cartProductText = cartProduct.getText();
		System.out.println(cartProductText);

		staticwait();

		if (selectedProductText.contains("CD single Indian Songs")) {
			close();
		}

		staticwait();

		quit();
	}

	@Test
	public void brokenLinks() {

		log.info("Browser Launch");

		getUrl("https://www.amazon.in");
		implicitwait();

		String URL = driver.getCurrentUrl();
		Assert.assertTrue(URL.contains("https://www.amazon.in"));

		List<WebElement> allLinks = driver.findElements(By.tagName("a"));

		for (int i = 0; i < allLinks.size(); i++) {

			WebElement links = allLinks.get(i);

			String link = links.getAttribute("href");

			try {

				URL url = new URL(link);

				URLConnection o = url.openConnection();

				HttpURLConnection h = (HttpURLConnection) o;

				int responseCode = h.getResponseCode();

				if (responseCode < 200 || responseCode > 200) {

					System.out.println(link);
				}

			} catch (Throwable e) {

				System.out.println("Malformed Exception");
			}

		}

	}

}
