package com.helper;

import org.openqa.selenium.WebDriver;

import com.pom.Add_To_Cart;
import com.pom.Home_Page_Login;
import com.pom.Home_Page_SearchBox;
import com.pom.Product_Page;
import com.pom.Results_Page;
import com.pom.Shopping_Cart_Page;

public class Page_Object_Manager {
public WebDriver driver;
	
	public Page_Object_Manager(WebDriver driver2) {
		this.driver = driver2;
	}
	
	private Home_Page_Login li;
	public Home_Page_Login getInstanceli() {
		if(li == null) {
			li = new Home_Page_Login(driver);
		}
		return li;
	}
	
	private Home_Page_SearchBox sb;
	public Home_Page_SearchBox getInstancesb() {
		if(sb == null) {
			sb = new Home_Page_SearchBox(driver);
		}
		return sb;
	}
	
	private Results_Page rp;
	public Results_Page getInstancerp() {
		if(rp == null) {
			rp = new Results_Page(driver);
		}
		return rp;
	}
	
	private Product_Page pp;
	public Product_Page getInstancepp() {
		if(pp == null) {
			pp = new Product_Page(driver);
		}
		return pp;
	}
	
	private Add_To_Cart atc;
	public Add_To_Cart getInstanceatc() {
		if(atc == null) {
			atc = new Add_To_Cart(driver);
		}
		return atc;
	}
	
	private Shopping_Cart_Page scp;
	public Shopping_Cart_Page getInstancescp() {
		if(scp == null) {
			scp = new Shopping_Cart_Page(driver);
		}
		return scp;
	}

}

