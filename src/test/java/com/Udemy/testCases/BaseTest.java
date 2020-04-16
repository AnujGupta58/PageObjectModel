package com.Udemy.testCases;

import org.testng.annotations.AfterSuite;

import com.Udemy.base.Page;

public class BaseTest {

	@AfterSuite
	public void tearDown() {
		Page.quit();
	}
}
