package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Logout {

	public WebDriver driver;

	@FindBy(xpath = "//strong[@class='d-md-inline-block d-none']")
	private WebElement admin;

	@FindBy(xpath = "//a[normalize-space()='Log Out']")
	private WebElement logout;

	public Logout(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getAdmin() {
		return admin;
	}

	public WebElement getLogout() {
		return logout;
	}

}
