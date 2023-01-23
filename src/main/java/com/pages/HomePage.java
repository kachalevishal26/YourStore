package com.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath = "//a[contains(text(),'Monitors')]")
	WebElement selProduct;
	
//	@FindBy(xpath = "//span[contains(text(),'Add to Cart')]")
//	WebElement addToCart;

	public HomePage() {
		PageFactory.initElements(driver, this);
	}

	public void selectProduct() throws InterruptedException {
		Thread.sleep(2000);
		WebElement comp = driver.findElement(By.linkText("Components"));
		Actions action = new Actions(driver);
		action.moveToElement(comp).build().perform();

		Thread.sleep(2000);
		List<WebElement> ddOptions = driver.findElements(By.xpath("//*[@class='list-unstyled']/li"));
		System.out.println(ddOptions);
		for (int i = 0; i <= ddOptions.size() - 1; i++) {
			String text = prop.getProperty("productName");
			if (ddOptions.get(i).getText().contains(text)) {
				ddOptions.get(i).click();
				break;
			}
		}
	}
	
	public void addProduct() throws InterruptedException {
		JavascriptExecutor  js = (JavascriptExecutor)driver;
		js.executeScript("scroll(0,200)");
		WebElement addCartBtn = driver.findElements(By.xpath("//span[contains(text(),'Add to Cart')]")).get(0);
		addCartBtn.click();
		Thread.sleep(1000);
		js.executeScript("scroll(0,790)");
		List<WebElement> allOptions = driver.findElements(By.id("input-option218"));
		System.out.println(allOptions);
		for (int i = 0; i < allOptions.size(); i++) {
			if(allOptions.get(i).getText().contains("Small")) {
				allOptions.get(i).click();
				break;
			}
		}
	}
}
