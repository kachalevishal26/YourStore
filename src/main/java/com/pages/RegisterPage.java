package com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class RegisterPage extends TestBase {
	// PageObject or Object Repository
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAcc;

	@FindBy(xpath = "//a[contains(text(),'Register')]")
	WebElement regBtn;

	@FindBy(id = "input-firstname")
	WebElement fName;

	@FindBy(id = "input-lastname")
	WebElement lName;

	@FindBy(id = "input-email")
	WebElement eMail;

	@FindBy(id = "input-telephone")
	WebElement phNo;

	@FindBy(id = "input-password")
	WebElement pwd;

	@FindBy(id = "input-confirm")
	WebElement cPwd;

	@FindBy(xpath = "//body/div[@id='account-register']/div[1]/div[1]/form[1]/div[1]/div[1]/input[1]")
	WebElement privacyBox;

	@FindBy(xpath = "//input[@class='btn btn-primary']")
	WebElement registerBtn;

	@FindBy(xpath = "//a[contains(text(),'Continue')]")
	WebElement continueBtn;

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	public void navToRegPage() {
		myAcc.click();
		regBtn.click();
	}

	public HomePage fillDetails(String firstName, String lastName, String email, String phone, String password,
			String cPassword) {
		fName.sendKeys(firstName);
		lName.sendKeys(lastName);
		eMail.sendKeys(email);
		phNo.sendKeys(phone);
		pwd.sendKeys(password);
		cPwd.sendKeys(cPassword);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("scroll(0,250)");
		privacyBox.click();
		registerBtn.click();

		return new HomePage();
	}

	public String verifyLogin() {
		String title = driver.getTitle();
		

		return title;
	}
}
