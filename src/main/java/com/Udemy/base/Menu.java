package com.Udemy.base;

import org.openqa.selenium.WebDriver;

import com.Udemy.pages.Dashboard;

public class Menu {
	
	//SubMenu sub;
	
	WebDriver driver;
	
	public Menu(WebDriver driver) {
		this.driver = driver;
	}

	public void clickOnGeneral() {
		//driver.findElement(By.xpath("//ul[@id=\"social-sidebar-menu\"]/li[4]/a[contains(text(),'General')]")).click();
		Page.click("clickOnGeneral_XPath");
	}
	
	public Dashboard navigateToDashboard() {
		//driver.findElement(By.xpath("//strong[contains(text(),'Dashboard')]")).click();
		Page.click("dashboard_XPath");
		return new Dashboard();
	}

	public void navigateToUpdates() {

	}

	public void navigateToModules() {

	}

	public void navigateToGeneral(SubMenu sub) {
		switch (sub) { 
		case SETTINGS:
			clickOnGeneral();
			//driver.findElement(By.xpath("//ul[@id='menu-ui']/li[1]")).click();
			Page.click("general_settings_XPath");
			break;
		case CURRENCIES:
			clickOnGeneral();
			//driver.findElement(By.xpath("//ul[@id='menu-ui']/li[2]")).click();
			Page.click("general_currencies_XPath");
			break;
		case SOCIAL_CONNECTIONS:
			clickOnGeneral();
			//driver.findElement(By.xpath("//ul[@id='menu-ui']/li[4]")).click();
			Page.click("general_social_XPath");
			break;
		default:
			navigateToDashboard();
		}
	}
	

	public void loctions() {

	}

	public void navigateToCoupons() {

	}
	
	public void logout() {
		Page.click("logout_XPath");
	}
}
