package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Dashboard {

	public WebDriver driver;

	@FindBy(xpath = "//span[normalize-space()='Settings']")
	private WebElement settings;

	@FindBy(xpath = "//span[normalize-space()='Canteens']")
	private WebElement canteens;

	public Dashboard(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSettings() {
		return settings;
	}

	public WebElement getCanteens() {
		return canteens;
	}

}
