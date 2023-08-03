package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {

public WebDriver driver;
	
	@FindBy(id= "productTitle")
	private WebElement selectedProduct;
	
	@FindBy(id= "add-to-cart-button")
	private WebElement atcButton;
	
	public Product_Page(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSelectedProduct() {
		return selectedProduct;
	
	}
	
	public WebElement getAtcButton() {
		return atcButton;
	}
	
	
}
