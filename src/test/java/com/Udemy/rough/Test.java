package com.Udemy.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Anuj Gupta\\JavaProjects\\PageObjectModel\\src\\test\\resources\\com\\Udemy\\executables\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.phptravels.net/admin");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@type=\"text\"]")).sendKeys("admin@phptravels.com");
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("demoadmin");
		driver.findElement(By.xpath("//button[@type=\"submit\"]")).click();		
		System.out.println("reached");
	}	

}
