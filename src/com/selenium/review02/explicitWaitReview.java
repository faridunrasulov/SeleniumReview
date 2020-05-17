package com.selenium.review02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class explicitWaitReview {

	public static String url = "http://jiravm.centralus.cloudapp.azure.com:8081/jquery-download-progress-bar-demo.html";

	public static void main(String[] args) {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		WebElement downloadButt = driver.findElement(By.id("downloadButton"));
		downloadButt.click();
		
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[text()='Complete!']")));
		WebElement complete = driver.findElement(By.xpath("//div[text()='Complete!']"));
		String completeTxt = complete.getText();
		System.out.println(completeTxt);
		
		WebElement close = driver.findElement(By.xpath("//button[text()='Close']"));
		wait.until(ExpectedConditions.elementToBeClickable(close));
		close.click();
		
		
		
	}

}
