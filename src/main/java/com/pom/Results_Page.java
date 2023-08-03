package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Results_Page {
	
public WebDriver driver;
	
	@FindBy(xpath= "//span[text()='Results']//ancestor::div[4]//following-sibling::div[1]//h2//a")
	private WebElement firstProduct;
	
	public Results_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getFirstProduct() {
		return firstProduct;
	}

	
}
