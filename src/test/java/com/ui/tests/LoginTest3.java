package com.ui.tests;
import static org.testng.Assert.*; // assert can also be a static import so that it doesn't get the 

import org.apache.logging.log4j.Logger;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.constants.Browser;
import com.ui.pages.HomePage;
import com.ui.pojo.User;
import com.utility.LoggerUtility;

@Listeners({com.ui.listeners.TestListener.class})
public class LoginTest3 extends TestBase {
//	HomePage homePage;
//	@BeforeMethod(description = "Load the HomePage of the website")
//	public void SetUp() {
//		homePage = new HomePage(Browser.CHROME);
//	}
	
	@Test(description = "Verifies if the valid user is able to login into the application", groups = {"E2E", "sanity"}, 
			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestDataProvider")
	public void loginTest(User user){
		assertEquals(homePage.goToLogin().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sunn babe");
	}
	
//	@Test(description = "Verifies if the valid user is able to login into the application", groups = {"E2E", "sanity"}, 
//			dataProviderClass = com.ui.dataproviders.LoginDataProvider.class, dataProvider = "LoginTestCSVDataProvider", retryAnalyzer = com.ui.listeners.MyRetryAnalyzer.class)
//	public void loginCSVTest(User user) {
//		assertEquals(homePage.goToLogin().doLoginWith(user.getEmailAddress(), user.getPassword()).getUserName(), "Sunn babe");
//	}
	
}
