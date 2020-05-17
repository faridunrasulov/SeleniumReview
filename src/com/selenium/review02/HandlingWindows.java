package com.selenium.review02;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.java.util.BaseClass;

public class HandlingWindows {

	public static String url = "http://www.seleniumframework.com/Practiceform/";

	public static void main(String[] args) {

		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
		driver.findElement(By.cssSelector("button[onclick='newBrwTab()']")).click();
		
		Set<String> allLinks = driver.getWindowHandles();
		Iterator<String> it = allLinks.iterator();
		System.out.println(allLinks.size());
		
		String parentId = it.next();
		driver.close();
		String childId = it.next();
		driver.switchTo().window(childId);
		String longText = driver.findElement(By.xpath("//strong[contains(text(),'Agile Testing')]")).getText();
		System.out.println(longText);
		driver.close();
		
		
		

	}

}
