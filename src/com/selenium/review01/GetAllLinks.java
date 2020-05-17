package com.selenium.review01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.util.BaseClass;
import com.java.util.Exceptions;

public class GetAllLinks {

	public static void main(String[] args) {
		
		WebDriver driver = BaseClass.setUp();
		
		List<WebElement> allLinks= driver.findElements(By.tagName("a"));
		int numOfLinks = allLinks.size();
		System.out.println(numOfLinks);
		for (WebElement links : allLinks) {
			String linkText = links.getText();
			String hrefLinks = links.getAttribute("href");
			System.out.println(linkText + " ---> "+hrefLinks);
		}
		
		
		
		Exceptions.sleep(2000);
		BaseClass.tearDown();
	}

}
