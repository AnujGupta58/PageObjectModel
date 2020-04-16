package com.Udemy.testCases;

import java.io.IOException;
import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.Udemy.base.Page;
import com.Udemy.base.SubMenu;
import com.Udemy.pages.Bookings;
import com.Udemy.pages.Customers;
import com.Udemy.pages.Dashboard;
import com.Udemy.pages.LoginPage;
import com.Udemy.utilities.Utilities;

public class LoginTest extends BaseTest {
	
	@Test(dataProviderClass = Utilities.class , dataProvider = "dp")
	public void loginTest(Hashtable<String, String> data) throws IOException {
		LoginPage loginPage = new LoginPage();
		Dashboard dashboard = loginPage.doLogin(data.get("username"),data.get("password"));
		Customers customers = dashboard.customers();
		System.out.println("Forwarded to Customer page");
		
//		Bookings bookings = new Bookings();
//		bookings.validateTitleText();
//		Page.menu.navigateToDashboard();
//		Page.menu.logout();
		//Assert.fail("Failed in TestCase");
		
		System.out.println("Done");
	}
	
}
