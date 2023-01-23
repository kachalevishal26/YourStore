package com.testcases;

import static org.testng.Assert.assertEquals;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.base.TestBase;
import com.pages.LoginPage;
import com.utils.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginPage;

	public LoginPageTest() {
		super();
	}

	@BeforeTest
	public void setup() {
		initialization();
		loginPage = new LoginPage();
	}

	@DataProvider
	public Object[][] excelData() {
		Object data[][] = TestUtil.getData("login");

		return data;
	}

	@Test
	public void NavLoginPage() {
		loginPage.navToLoginPage();
	}

	@Test(dataProvider = "excelData")
	public void loginTest(String id, String pwd) {
		loginPage.loginCred(id, pwd);
	}

	@Test
	public void verifyLogin() {
		String title = loginPage.verifyLogin();
		assertEquals(title, "My Account", "Login Failed!");
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
