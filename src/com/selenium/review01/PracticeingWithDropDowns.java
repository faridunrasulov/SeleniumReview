package com.selenium.review01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.java.util.BaseClass;
import com.java.util.Exceptions;



public class PracticeingWithDropDowns {

	public static void main(String[] args) {
		
		WebDriver driver = BaseClass.setUp();
		
		List<WebElement> allDD = driver.findElements(By.tagName("a"));
		
		Exceptions.sleep(3000);
		for(WebElement oneDD : allDD) {
			String text = oneDD.getText();
			System.out.println(text);
			if(text.equals("List Box")) {
				oneDD.click();
			}
			if(text.equals("Bootstrap List Box")) {
				oneDD.click();
				break;
			}
		}
		Exceptions.sleep(1000);
		
		List<WebElement> listofDD = driver.findElements(By.tagName("li"));
		for(WebElement oneItem : listofDD) {
			String str = oneItem.getText();
			System.out.println(str);
			
			if(str.equals("Morbi leo risus")) {
				oneItem.click();
				break;
			}
			
		}
		Exceptions.sleep(2000);
		BaseClass.tearDown();
	}

}
