package com.Udemy.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Udemy.base.Page;
import com.Udemy.base.SubMenu;
import com.Udemy.pages.Customers;
import com.Udemy.pages.Dashboard;

public class CustomerTest extends BaseTest{

	@Test
	public void customerTest() {
		Customers customers = new Customers();
		String text = customers.getPageText();
		Assert.assertEquals("Customers Management", text);		
		Page.menu.navigateToGeneral(SubMenu.OTHER);
		System.out.println("here");
		//dashboard.goToBookings();
	}
}
