package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_SearchBox {
	
public WebDriver driver;
	
	@FindBy(id= "searchDropdownBox")
	private WebElement dropDown;
	
	@FindBy(id = "twotabsearchtextbox")
	private WebElement searchBox;
	
	@FindBy(id = "nav-search-submit-button")
	private WebElement submit; 
	
	public Home_Page_SearchBox(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getDropDown() {
		return dropDown;
	}

	public WebElement getSearchBox() {
		return searchBox;
	}

	public WebElement getSubmit() {
		return submit;
	}
	

}
