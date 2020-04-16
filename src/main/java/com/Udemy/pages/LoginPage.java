package com.Udemy.pages;

import com.Udemy.base.Page;

public class LoginPage extends Page {
	
//	public By userName = By.xpath(or.getProperty("userName_XPath"));
//	public By password = By.xpath(or.getProperty("password_XPath"));
//	public By loginInbutton = By.xpath(or.getProperty("loginInbutton_XPath"));
	
	public Dashboard doLogin(String userName, String password) {
		setUserName(userName);
		setPassword(password);
		clickOnLoginIn();
		return new Dashboard();
	}
	
	
	public void setUserName(String userName) {
		//driver.findElement(userName).sendKeys("admin@phptravels.com");
		type("userName_XPath", userName);
		
	}
	
	public void setPassword(String password) {
		//driver.findElement(password).sendKeys("demoadmin");
		type("password_XPath", password);
	}
	
	public void clickOnLoginIn() {
		//driver.findElement(loginInbutton).click();
		click("loginInbutton_XPath");
	}
	
}
