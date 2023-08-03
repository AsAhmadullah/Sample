package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Add_To_Cart {

public WebDriver driver;
	
	@FindBy(xpath= "(//a[@class='a-button-text'])[3]")
	private WebElement gtcButton;
	
	public Add_To_Cart(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getGtcButton() {
		return gtcButton;
	}
	
}
