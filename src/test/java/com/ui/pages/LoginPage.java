package com.ui.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.utility.BrowserUtility;

public class LoginPage extends BrowserUtility{
	private final static By EMAIL_TEXTBOX_LOCATOR = By.id("email");
	private final static By PASSWORD_TEXTBOX_LOCATOR = By.id("passwd");
	private final static By SUBMIT_BTN_LOCATOR = By.id("SubmitLogin");
	
	public LoginPage(WebDriver driver) {
		super(driver);
	}
	
	public MyAccountPage doLoginWith(String emailID, String password) {
		enterText(EMAIL_TEXTBOX_LOCATOR, emailID);
		enterText(PASSWORD_TEXTBOX_LOCATOR, password);
		clickOn(SUBMIT_BTN_LOCATOR);
		MyAccountPage myAccountPage = new MyAccountPage(getWebDriver());
		return myAccountPage;
	}
}
