package com.Udemy.pages.bookings;

import java.io.IOException;

import org.openqa.selenium.By;

import com.Udemy.base.Page;

public class EditBooking extends Page {

	public String validateTitleText() throws IOException {
		String text = driver.findElement(By.xpath(or.getProperty("Editing_headerText_XPath"))).getText();
		verifyEquals("Edit Booking", text);
		return text;
	}
}
