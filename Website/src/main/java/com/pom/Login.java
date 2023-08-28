package com.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login {

	public WebDriver driver;

	@FindBy(id = "email")
	private WebElement username;

	@FindBy(name = "password")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement signin;

	public Login(WebDriver driver2) {
		this.driver = driver2;
		PageFactory.initElements(driver, this);

	}

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getSignin() {
		return signin;
	}

}
