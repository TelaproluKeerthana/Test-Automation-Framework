package com.ui.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.utility.BrowserUtility;

public class LoginTest {

	public static void main(String[] args) {
		
		WebDriver wd = new ChromeDriver(); // launches the browser session
		
		BrowserUtility browserUtility = new BrowserUtility(wd);
		browserUtility.goToWebsite("http://www.automationpractice.pl");
	
		browserUtility.maximizeWindow();
	
		By signInLinkLocator = By.xpath("//a[contains(text(), \"Sign\")]");
		browserUtility.clickOn(signInLinkLocator);
		
		By emailIdLocator = By.id("email");
		browserUtility.enterText(emailIdLocator, "webehev913@dretnar.com");
		
		WebElement emailIdWebElement = wd.findElement(emailIdLocator);
		emailIdWebElement.sendKeys();
		
		By passTextBoxLocator = By.id("passwd");
		browserUtility.enterText(passTextBoxLocator, "password");
		
		WebElement passTextBoxWebElement = wd.findElement(passTextBoxLocator);
		passTextBoxWebElement.sendKeys("password");
		
		By submitBtnLocator = By.id("SubmitLogin");
		WebElement submitBtnWebElement = wd.findElement(submitBtnLocator);
		submitBtnWebElement.click();		
	}

}
