package com.helper;

import org.openqa.selenium.WebDriver;

import com.pom.CanteenList;
import com.pom.Dashboard;
import com.pom.Login;
import com.pom.Logout;
import com.pom.NewCanteen;

public class PageObjectManager {

	public WebDriver driver;

	public PageObjectManager(WebDriver driver2) {
		this.driver = driver2;
	}

	private Login li;

	public Login getInstanceli() {
		if (li == null) {
			li = new Login(driver);
		}
		return li;
	}

	private Dashboard db;

	public Dashboard getInstancedb() {
		if (db == null) {
			db = new Dashboard(driver);
		}
		return db;
	}

	private CanteenList cl;

	public CanteenList getInstancecl() {
		if (cl == null) {
			cl = new CanteenList(driver);
		}
		return cl;
	}

	private NewCanteen nc;

	public NewCanteen getInstancenc() {
		if (nc == null) {
			nc = new NewCanteen(driver);
		}
		return nc;
	}

	private Logout lo;

	public Logout getInstancelo() {
		if (lo == null) {
			lo = new Logout(driver);
		}
		return lo;
	}

}
