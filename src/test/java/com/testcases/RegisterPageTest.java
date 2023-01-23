package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.HomePage;
import com.pages.RegisterPage;
import com.utils.TestUtil;

public class RegisterPageTest extends TestBase {
	RegisterPage registerPage;
	HomePage homePage;

	public RegisterPageTest() {
		super();
	}

	@BeforeTest
	public void setUp() {
		initialization();
		registerPage = new RegisterPage();
	}

	@Test
	public void navRegPage() {
		registerPage.navToRegPage();
	}
	
	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtil.getData("register");
		
		return data;
	}

	@Test(dataProvider = "excelData")
	public void fillRegDetails(String firstName, String lastName, String email, String phone, String password,
			String cPassword) {
		homePage = registerPage.fillDetails(firstName, lastName, email, phone, password, cPassword);
	}

	@Test
	public void verifyReg() {
		String title = registerPage.verifyLogin();
		assertEquals(title, "Your Account Has Been Created!", "Registration Failed!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
