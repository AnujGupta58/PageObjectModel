package com.Udemy.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.Reporter;

import com.Udemy.utilities.ExcelUtility;
import com.Udemy.utilities.ExtentManager;
import com.Udemy.utilities.Utilities;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.github.bonigarcia.wdm.WebDriverManager;


public class Page {
	
	public static WebDriver driver = null;
	public static Menu menu;
	
	public static Properties config = new Properties();
	public static Properties or = new Properties();
	public static FileInputStream fis;
	public static Logger log = 	Logger.getLogger("devpinoyLogger");
	public static ExcelUtility excel = new ExcelUtility(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Udemy\\excel\\testData.xlsx");
	public static ExtentReports reports = ExtentManager.getInstance();
	public static ExtentTest t;
	public static WebElement dropdown;
	
	
	public Page() {
		
		if(driver==null){
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Udemy\\properties\\Config.properties");
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("config properties loaded..");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\com\\Udemy\\properties\\OR.properties");
			}
			catch (FileNotFoundException e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			try {
				or.load(fis);
				log.debug("object repository  properties loaded..");
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			
			if(config.getProperty("browser").equals("chrome")) {
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("chrome browser is launched");
//				System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anuj Gupta\\JavaProjects\\PageObjectModel\\src\\test\\resources\\com\\Udemy\\executables\\chromedriver.exe");
//				driver = new ChromeDriver();
			}
			else if(config.getProperty("browser").equals("firefox")) {
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				log.debug("firefox browser is launched");
			}
			else if(config.getProperty("browser").equals("ie")) {
				WebDriverManager.iedriver().setup();
				driver = new InternetExplorerDriver();
				log.debug("ie browser is launched");
			}
			
			
			driver.get(config.getProperty("testSiteURL"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
			menu = new Menu(driver);
		}
	}
	
	public boolean isELementPresent(By by) {
		try {
			driver.findElement(by);
			return true;
		}
		catch (NoSuchElementException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public static void click(String locator) {
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_XPath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).click();
		}
		else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(locator)).click();
		}
		
		log.debug("Clicking on an Element : " + locator);
		t.log(LogStatus.INFO, "Clicking on : " + locator);
	}
	
	public void type(String locator, String value) {
		if(locator.endsWith("_CSS")) {
			driver.findElement(By.cssSelector(or.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_XPath")) {
			driver.findElement(By.xpath(or.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_ID")) {
			driver.findElement(By.id(locator)).sendKeys(value);
		}
		
		log.debug("Typing in an Element : " + locator + " entered value as : " + value);

		t.log(LogStatus.INFO, "Typing in : " + locator + " entered value as " + value);
	}
	
	public void select(String locator, String value) {
		if(locator.endsWith("_CSS")) {
			dropdown = driver.findElement(By.cssSelector(or.getProperty(locator)));
		}
		else if(locator.endsWith("_XPath")) {
			dropdown = driver.findElement(By.xpath(or.getProperty(locator)));
		}
		else if(locator.endsWith("_ID")) {
			dropdown = driver.findElement(By.id(locator));
		}
		
		Select select = new Select(dropdown);
		select.selectByVisibleText(value);
	}
	
	public void verifyEquals(String expected, String actual) throws IOException {
		System.setProperty("org.uncommons.reportng.escape-output","false");
		try {
			Assert.assertEquals(actual, expected);
			Assert.fail("Failed");
		}
		catch (Throwable th) {
			Utilities.captureScreenshot();
			
			Reporter.log("<br>" + "Verification fails : " + th.getMessage()+ "<br>");
			Reporter.log("<a target =\"_blank\" href= "+Utilities.screenshotName+"><img src="+Utilities.screenshotName+" height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
		}
	}
	
	public static void quit() {
		driver.quit();
	}
}
