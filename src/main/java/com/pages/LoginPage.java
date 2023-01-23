package com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class LoginPage extends TestBase {
	@FindBy(xpath = "//span[contains(text(),'My Account')]")
	WebElement myAcc;
	
	@FindBy(id = "input-email")
	WebElement emailId;
	
	@FindBy(id = "input-password")
	WebElement passWord;
	
	@FindBy(xpath = "//input[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath = "//a[contains(text(),'Login')]")
	WebElement navLoginBtn;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public void navToLoginPage() {
		myAcc.click();
		navLoginBtn.click();
	}
	
	public void loginCred(String uId, String pwd) {
		emailId.sendKeys(uId);
		passWord.sendKeys(pwd);
		loginBtn.click();
	}
	
	public String verifyLogin() {
		String title = driver.getTitle();
		return title;
	}	
}
