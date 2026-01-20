package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.constants.Browser;

public class BrowserUtility {
	
	protected static ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	Logger logger = LoggerUtility.getLogger(this.getClass());
  
	
//	public BrowserUtility(String browserName) {
//		logger.info("Launching the browser "+browserName);
//		if(browserName.equalsIgnoreCase("chrome")) {
//			webDriver.set(new ChromeDriver());
//		}
//		else if(browserName.equalsIgnoreCase("edge")) {
//			webDriver.set(new EdgeDriver());
//		}
//		else {
//			logger.error("Invalid Browser please choose between chrome/Edge");
//			System.err.print("Invalid browserName");
//		}
//		}
	
//	public BrowserUtility(String browserName, boolean isHeadLess) {
//		logger.info("Launching the browser "+browserName);
//		if(browserName.equalsIgnoreCase("chrome")) {
//			if(isHeadLess) {
//				ChromeOptions chromeOptions = new ChromeOptions();
//				chromeOptions.addArguments("--headless=new");
//				chromeOptions.addArguments("--window-size=1920,1080");
//				chromeOptions.addArguments("--disable-gpu");
//
//				webDriver.set(new ChromeDriver(chromeOptions));
//
//			}
//			else {
//				webDriver.set(new ChromeDriver());
//			}
//		}
//		else if(browserName.equalsIgnoreCase("edge")) {
//			webDriver.set(new EdgeDriver());
//		}
//		else {
//			logger.error("Invalid Browser please choose between chrome/Edge");
//			System.err.print("Invalid browserName");
//		}
//		
//	}
	
	public BrowserUtility(Browser browserName, boolean isHeadLess) {
		if(browserName == Browser.CHROME) {
			if(isHeadLess) {
				ChromeOptions chromeOptions = new ChromeOptions();
				chromeOptions.addArguments("--headless=new");
				chromeOptions.addArguments("--window-size=1920,1080");
				chromeOptions.addArguments("--disable-gpu");
				chromeOptions.addArguments("--no-sandbox");
				chromeOptions.addArguments("--disable-dev-shm-usage");
				webDriver.set(new ChromeDriver(chromeOptions));
			}
			else {
				webDriver.set(new ChromeDriver());
			}
		}
		else if(browserName == Browser.EDGE) {
			if(isHeadLess) {
				EdgeOptions edgeOptions = new EdgeOptions();
				edgeOptions.addArguments("--headless=old");
				edgeOptions.addArguments("disable-gpu");
				webDriver.set(new EdgeDriver(edgeOptions));
			}
			else {
				webDriver.set(new EdgeDriver());
			}
		}
		else if(browserName == Browser.FIREFOX) {
			if(isHeadLess) {
				FirefoxOptions firefoxOptions = new FirefoxOptions();
				firefoxOptions.addArguments("--headless=old");
				firefoxOptions.addArguments("disable-gpu");
				webDriver.set(new FirefoxDriver(firefoxOptions));
			}
			else {
				webDriver.set(new FirefoxDriver());
			}
			
		}
	}
	public WebDriver getWebDriver() {
		return webDriver.get();
	}
	
	public BrowserUtility(WebDriver webDriver) {
		this.webDriver.set(webDriver);
	}
	
	public void goToWebsite(String url) {
		logger.info("Visiting the website "+url);
		webDriver.get().get(url);
		
	}
	
	public void maximizeWindow() {
		logger.info("Maximizing the window ");
		webDriver.get().manage().window().maximize();
	}
	
	public void clickOn(By locator) {
		logger.info("Clicked on the element "+locator);
		webDriver.get().findElement(locator).click();
		logger.info("Element found clicked the element ");
	}
	
	public void enterText(By locator, String data) {
		logger.info("Entering the text into "+locator);
		WebElement element = webDriver.get().findElement(locator);
		logger.info("Element found now enter the text into "+data);
		element.sendKeys(data);
	}
	
	public String getVisibleText(By locator) {
		logger.info("Trying to get the text from the "+locator);
		WebElement element = webDriver.get().findElement(locator);
		logger.info("Element found entered returning the text");
		return element.getText();
	}
	public String takeScreenShot(String name) {
		TakesScreenshot screenshot = (TakesScreenshot) driver.get();

		File screenshotData = screenshot.getScreenshotAs(OutputType.FILE);
		Date date = new Date();
		SimpleDateFormat format = new SimpleDateFormat("HH-mm-ss");
		String timeStamp = format.format(date);
		String path = "./screenshots/" + name + " - " + timeStamp + ".png";
		File screenshotFile = new File(path);
		try {
			FileUtils.copyFile(screenshotData, screenshotFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return path;
	}
	public void quit() {
	    if (webDriver.get() != null) {
	        logger.info("Quitting WebDriver");
	        webDriver.get().quit();
	        webDriver.remove();
	    }
	}


	
}
