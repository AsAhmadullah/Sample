package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Shopping_Cart_Page {
	
public WebDriver driver;
	
	@FindBy(xpath= "//span[@class='a-list-item']/parent::li[@class='a-spacing-mini']")
	private WebElement cartProduct;
	
	public Shopping_Cart_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}


}
