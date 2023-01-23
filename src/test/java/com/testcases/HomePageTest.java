package com.testcases;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;

public class HomePageTest extends TestBase {
	HomePage homePage;
	
	public HomePageTest() {
		super();
	}
	
	@BeforeTest
	public void setup() {
		initialization();
		homePage = new HomePage();
	}
	
	@Test
	public void addProd() throws InterruptedException {
		homePage.selectProduct();
		homePage.addProduct();
	}
	
//	@AfterTest
//	public void tearDown() {
//		driver.quit();
//	}
}