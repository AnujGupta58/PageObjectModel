package com.Udemy.rough;

import com.Udemy.pages.Dashboard;
import com.Udemy.pages.LoginPage;
import com.Udemy.pages.Customers;

public class LoginTest {

	public static void main(String[] args) throws InterruptedException {
		
		LoginPage loginPage = new LoginPage();
		Dashboard dashboard = loginPage.doLogin("","");
		Customers customers = dashboard.customers();
		System.out.println(customers.getPageText());
		//Page.menu.navigateToGeneral("social_connections");
		System.out.println("Done");
	}
}
