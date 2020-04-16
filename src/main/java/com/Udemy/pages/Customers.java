package com.Udemy.pages;

import org.openqa.selenium.By;

import com.Udemy.base.Page;

public class Customers extends Page {
	
	public String getPageText() {
		String pageText = driver.findElement(By.xpath(or.getProperty("Customer_headerTest_XPath"))).getText();
		return pageText;
	}
}
