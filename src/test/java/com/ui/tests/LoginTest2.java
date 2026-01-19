package com.ui.tests;
import static com.constants.Browser.*;
import static org.testng.Assert.assertEquals;

import com.ui.pages.HomePage;
import com.ui.pages.LoginPage;

public class LoginTest2 {
	public static void main(String args[]) {
		HomePage homePage = new HomePage(EDGE, true);
		homePage.goToWebsite("http://www.automationpractice.pl");
		LoginPage loginPage = homePage.goToLogin();
		loginPage.doLoginWith("webehev913@dretnar.com", "password");
		
	}
}
// by adding a beforeMethod annotation we just setup and with the below line we can refactor this particular test
// assertEquals(homePage.goToLogin().doLoginWith("webehev913@dretnar.com", "password").getUserName(), "Sunn babe");