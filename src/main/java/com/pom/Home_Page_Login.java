package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page_Login {

	public WebDriver driver;
	
	@FindBy(xpath= "//span[text()='Sign in']")
	private WebElement signin;
	
	@FindBy(name = "email")
	private WebElement username;
	
	@FindBy(id = "continue")
	private WebElement next;
	
	@FindBy(name = "password")
	private WebElement password;
	
	@FindBy(id = "signInSubmit")
	private WebElement login;
	
	public Home_Page_Login(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);
	}

	public WebElement getSignin() {
		return signin;
	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getNext() {
		return next;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLogin() {
		return login;
	}
	
}
