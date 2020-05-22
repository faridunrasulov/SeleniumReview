package com.java.util;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * this method will set the browser and read the url
	 * 
	 * @return WebDriver
	 */

	public static WebDriver setUp() {
		ConfigsRead.readProperties(Constants.CONFIGS_PATH);
		
		switch(ConfigsRead.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver",Constants.CHROME_FILE_PATH);
			driver = new ChromeDriver();
			break;
		case"firefox":
			//System.setProperty(GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY, "true");
			System.setProperty("webdriver.chrome.driver",Constants.GECKO_FILE_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Invalid Browser");
		}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.get(ConfigsRead.getProperty("url"));
		
		return driver;
	}
	/**
	 * this method will quit the browser if browser is not null
	 */

	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}
