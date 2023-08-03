package com.base_Class;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	
	private static String value = null;
	public static WebDriver driver;
	
	// Browser Launch
	public static WebDriver openBrowser(String browser) {
		
		List<String> l = new LinkedList<>();
		l.add("start-maximized");
		l.add("incognito");
		l.add("disable-popup-blocking");
		l.add("enable-automation");
		l.add("deleteAllCookies");
		ChromeOptions options = new ChromeOptions();
		options.addArguments(l);
		
		if(browser.equalsIgnoreCase("chrome")) {
				
			WebDriverManager.chromedriver().setup();
			//System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Driver\\chromedriver.exe");
			driver = new ChromeDriver(options);
			
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Driver\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(browser.equalsIgnoreCase("edge")){
			WebDriverManager.firefoxdriver().setup();
			//System.setProperty("webdriver.edge.driver", System.getProperty("user.dir")+"\\Driver\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
	}
	// Get URL
	public static void getUrl(String url) {
		driver.get(url);
	}
	// Click On Element
	public static void clickonelement(WebElement element) {
		element.click();
	}
	// SendKeys
	public static void sendkeys(WebElement element, String input) {
		element.sendKeys(input);
	}	
	// Navigate To URL
	public static void navigateto(String url) {
		driver.navigate().to(url);
	}
	// Navigate Forward
	public static void navigateforward() {
		driver.navigate().forward();
	}
	// Navigate Back
	public static void navigateback() {
		driver.navigate().back();
	}
	// Navigate Refresh
	public static void navigaterefresh() {
		driver.navigate().refresh();
	}
	// Clear
	public static void clear(WebElement element) {
		element.clear();
	}
	// Close
	public static void close() {
		driver.close();
	}
	// Quit
	public static void quit() {
		driver.quit();
	}
	// Alert Accept
	public static void alertaccept() {
		driver.switchTo().alert().accept();
	}
	// Alert Dismiss
	public static void alertdismiss() {
		driver.switchTo().alert().dismiss();
	}
	// Alert SendKeys
	public static void alertsendkeys(String input) {
		driver.switchTo().alert().sendKeys(input);
	}
	// Mouse Action - Click
	public static void clickon(WebElement element) {
		Actions ac = new Actions(driver);
		ac.click(element).build().perform();
	}
	// Mouse Action - Right Click
	public static void rightclick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.contextClick(element).build().perform();
	}
	// Mouse Action - Double Click
	public static void doubleclick(WebElement element) {
		Actions ac = new Actions(driver);
		ac.doubleClick(element).build().perform();
	}
	// Mouse Action - Mouse Hover
	public static void mousehover(WebElement element) {
		Actions ac = new Actions(driver);
		ac.moveToElement(element).build().perform();
	}
	// Mouse Action - Drag and Drop
	public static void dragdrop(WebElement source,WebElement target) {
		Actions ac = new Actions(driver);
		ac.dragAndDrop(source, target).build().perform();
	}
	// Frame By id
	public static void frameid(String id) {
		driver.switchTo().frame(id);
	}
	// Frame By index
	public static void frameindex(int index) {
		driver.switchTo().frame(index);
	}
	// Frame By WebElement
	public static void framewebelement(WebElement element) {
		driver.switchTo().frame(element);
	}
	// To Parent Frame
	public static void toparentframe() {
		driver.switchTo().parentFrame();
	}
	// From Frame To Main Page
	public static void frametomainpage() {
		driver.switchTo().defaultContent();
	}
	// Robot VK Up
	public static void vkup() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_UP);
		r.keyRelease(KeyEvent.VK_UP);
	}
	// Robot VK Down
	public static void vkdown() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_DOWN);
		r.keyRelease(KeyEvent.VK_DOWN);
	}
	// Robot VK Enter
	public static void vkenter() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}
	// Get Windows Handles
	public static void getwindowshandles() {
		Set<String>id = driver.getWindowHandles();
		for (String s : id) {
			String title = driver.switchTo().window(s).getTitle();
			System.out.println(title);
		}
	}
	// DropDown By Value
	public static void dropdownvalue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	// DropDown By Index
	public static void dropdownindex(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}
	// DropDown By Visible Text
	public static void dropdowntext(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);
	}
	//Is Multiple
	public static void ismultiple(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.isMultiple());
	}
	// Get Current URL
	public static void getcurrenturl() {
		System.out.println(driver.getCurrentUrl());
	}
	// Get Title
	public static void gettitle() {
		System.out.println(driver.getTitle());
	}
	// Get Text 
	public static void gettext(WebElement element) {
		System.out.println(element.getText());
	}
	// Get Attribute
	public static void getattribute(WebElement element, String input) {
		System.out.println(element.getAttribute(input));
	}
	// Get Options
	public static void getoptions(WebElement element) {
		Select s = new Select(element);
		java.util.List<WebElement> options = s.getOptions();
		for (WebElement webElement : options) {
			System.out.println(webElement.getText());
		}
	}
	// Get All Selected Options
	public static void getallselectedoptions(WebElement element) {
		Select s = new Select(element);
		java.util.List<WebElement> allSelectedOptions = s.getAllSelectedOptions();
		for (WebElement webElement : allSelectedOptions) {
			System.out.println(webElement.getText());
		}
	}
	// Get First Selected Options
	public static void getfirstselectedoptions(WebElement element) {
		Select s = new Select(element);
		System.out.println(s.getFirstSelectedOption());
	}
	// Is Enabled
	public static void isenabled(WebElement element) {
		System.out.println(element.isEnabled());
	}
	// Is selected
	public static void isselected(WebElement element) {
		System.out.println(element.isSelected());
	}
	// Is Displayed
	public static void isdisplayed(WebElement element) {
		System.out.println(element.isDisplayed());
	}
	// CheckBox Click
	public static void checkbox(WebElement element) {
		element.click();
	}
	// Radio Button
	public static void radiobutton(WebElement element) {
		element.click();
	}
	// Static Wait
	public static void staticwait() throws Throwable {
		Thread.sleep(3000);
	}
	// Implicit Wait
	@SuppressWarnings("deprecation")
	public static void implicitwait() {
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	// Explicit Wait
	public static void explicitwait(Duration sec, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, sec);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	// Scroll IntoView
	public static void scrollintoview(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView();", element);	
	}
	
	public static void click(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
	// Scroll By
	public static void scrollby(int element) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy();", element);
	}
	// Takes Screenshot - FileUtils
	public static void screenshot(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File start = ts.getScreenshotAs(OutputType.FILE);
		File end = new File(location);
		FileUtils.copyFile(start, end);
	}
	// Takes Screenshot - FileHandler
	public static void screenshothandler(String location) throws IOException {
		TakesScreenshot ts = (TakesScreenshot)driver;
		File start = ts.getScreenshotAs(OutputType.FILE);
		File end = new File(location);
		FileHandler.copy(start, end);
	}
	// Data Driven
	public static String particulardata(String path, int index, int row_index, int cell_index) throws Throwable {
		
		File f = new File(path);
		FileInputStream fis = new FileInputStream(f);
		Workbook wb = new XSSFWorkbook(fis);
		Sheet s = wb.getSheetAt(index);
		Row r = s.getRow(row_index);
		Cell c = r.getCell(cell_index);
		CellType type = c.getCellType();
		
		if (type.equals(CellType.STRING)) {
			value = c.getStringCellValue();
			
		} 
		else if (type.equals(CellType.NUMERIC)) {
			double d = c.getNumericCellValue();
			int i = (int)d;
			value = String.valueOf(i);
					
		}
		wb.close();
		return value;
	}

}
