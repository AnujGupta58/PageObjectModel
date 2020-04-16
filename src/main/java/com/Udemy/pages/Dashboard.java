package com.Udemy.pages;

import com.Udemy.base.Page;

public class Dashboard extends Page {

	public void goToBookings() {
		//driver.findElement(By.xpath(or.getProperty("bookings_XPath"))).click();
		click("bookings_XPath");
	}

	public void goToCMSpages() {
		//driver.findElement(By.xpath("//i[@class=\"fa fa-list-alt fa-lg\"]")).click();
		click("CMSpages_XPath");
	}

	public void goToBlog() {
		//driver.findElement(By.xpath("//i[@class=\"glyphicon glyphicon-th-large fa-lg\"]")).click();
		click("blog_XPath");
	}

	public void goToAccounts() {
		//driver.findElement(By.xpath("//i[@class=\"fa fa-user-circle\"]")).click();
		click("accounts_XPath");
	}

	public void admins() {
		//driver.findElement(By.xpath("//a[contains(text(),'Total Admins')]")).click();
		click("admins_XPath");
	}

	public void suppliers() {
		//driver.findElement(By.xpath("//a[contains(text(),'Total Suppliers')]")).click();
		click("suppliers_XPath");
	}

	public Customers customers() {
		//driver.findElement(By.xpath("//a[contains(text(),'Total Customers')]")).click();
		click("customers_XPath");
		return new Customers();
	}

	public void guests() {
		//driver.findElement(By.xpath("//a[contains(text(),'Total Guests')]")).click();
		click("guests_XPath");
	}

	public void bookings() {
		//driver.findElement(By.xpath("//a[contains(text(),'Total Bookings')]")).click();
		click("bookings_XPath");
	}

}
