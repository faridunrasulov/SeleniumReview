package com.selenium.review02;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.java.util.BaseClass;

public class HandlingAlerts extends BaseClass{
	public static String url = "http://www.seleniumframework.com/Practiceform/";

	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement simpleAlert = driver.findElement(By.cssSelector("button#alert"));
		simpleAlert.click();
		
		Thread.sleep(2000);
		Alert alert =driver.switchTo().alert();
		alert.accept();
		
		WebElement timingAlert = driver.findElement(By.cssSelector("button#timingAlert"));
		timingAlert.click();
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.alertIsPresent());
		Thread.sleep(2000);
		alert.accept();
		
		
		
		
		
		
		
		
		
		
	}

}
