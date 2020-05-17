package com.selenium.review01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.java.util.BaseClass;
import com.java.util.Exceptions;

public class ReviewTask {

	public static void main(String[] args) {

		WebDriver driver = BaseClass.setUp();
		
		WebElement element =  driver.findElement(By.id("searchDropdownBox"));
		Select select = new Select(element);
		
		List<WebElement> options = select.getOptions();
		for (WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
			if(text.equals("Books")) {
				option.click();
				break;
			}			
		}
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Harry potter");
		driver.findElement(By.cssSelector("input[value='Go']")).submit();
		WebElement checkBox =  driver.findElement(By.xpath("//span[text()='Unofficial Cookbook']"));
		if(checkBox.isEnabled()) {
			if(!checkBox.isSelected()) {
				checkBox.click();
			}
		}
		
		Exceptions.sleep(2000);
		BaseClass.tearDown();
	}

}
