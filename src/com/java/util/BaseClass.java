package com.java.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {
	public static WebDriver driver;
	/**
	 * this method will set the browser and read the url
	 * @return WebDriver
	 */

	public static WebDriver setUp() {
		ConfigsRead.readProperties(Constants.CONFIGS_PATH);
		
	   switch(ConfigsRead.getProperty("browser").toLowerCase()) {
	   
	    case "chrome":
		   System.setProperty("webdriver.chrome.driver", Constants.CHROME_FILE_PATH);
		   driver = new ChromeDriver();
		   break;
	    case"firefox":
			   System.setProperty("webdriver.gecko.driver", Constants.GECKO_FILE_PATH);
			   driver = new FirefoxDriver();
			   break;
		default:
			throw new RuntimeException("Invalid browser");
	   }
	   
		driver.get(ConfigsRead.getProperty("url"));
		return driver;
	}
	
	/**
	 * this method will quit the browser if browser is not null
	 */
	
	public static void tearDown() {
		if(driver != null) {
			driver.quit();
		}
	}
}
