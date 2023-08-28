package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CanteenList {
	
	public WebDriver driver;

	@FindBy(xpath = "//button[normalize-space()='New']")
	private WebElement create;
	
	@FindBy(xpath = "//button[@data-bs-dismiss='alert']")
	private WebElement dismiss;
	
	@FindBy(xpath = "//input[@type='search']")
	private WebElement search;
	
	@FindBy(xpath = "//td[@class='fw-bold sorting_1']")
	private WebElement text;
	
	@FindBy(xpath = "//a[@class='btn btn-primary btn-sm mr-1']")
	private WebElement update;
	
	@FindBy(xpath = "//i[@class='bi bi-arrow-counterclockwise']")
	private WebElement refresh;
	
	@FindBy(xpath = "(//button[@class='btn btn-danger btn-delete btn-sm mr-1'])[1]")
	private WebElement delete;
	
	@FindBy(xpath = "//button[normalize-space()='Yes, delete it!']")
	private WebElement deleteit;
	
	@FindBy(xpath = "//button[normalize-space()='OK']")
	private WebElement ok;
	
	public CanteenList(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreate() {
		return create;
	}

	public WebElement getDismiss() {
		return dismiss;
	}

	public WebElement getSearch() {
		return search;
	}

	public WebElement getText() {
		return text;
	}

	public WebElement getUpdate() {
		return update;
	}

	public WebElement getRefresh() {
		return refresh;
	}

	public WebElement getDelete() {
		return delete;
	}

	public WebElement getDeleteit() {
		return deleteit;
	}

	public WebElement getOk() {
		return ok;
	}

}
