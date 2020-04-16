package com.Udemy.pages;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Udemy.base.Page;

public class Bookings extends Page {
	
	public void validateTitleText() throws IOException {
		String pageText = driver.findElement(By.xpath(or.getProperty("Booking_headerText_XPath"))).getText();
		System.out.println(pageText);
		verifyEquals("abc", pageText);
		System.out.println("---");
		//return pageText;
	}
	
	public void clickOnEditBooking() {
		click("editBtn_XPath");
	}
}
