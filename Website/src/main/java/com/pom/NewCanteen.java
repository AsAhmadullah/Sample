package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class NewCanteen {

	public WebDriver driver;

	@FindBy(id = "canteen")
	private WebElement canteenname;

	@FindBy(id = "short_code")
	private WebElement canteencode;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement submit;

	public NewCanteen(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCanteenname() {
		return canteenname;
	}

	public WebElement getCanteencode() {
		return canteencode;
	}

	public WebElement getSubmit() {
		return submit;
	}

}
