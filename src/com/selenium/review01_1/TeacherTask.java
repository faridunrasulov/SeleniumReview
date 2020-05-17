package com.selenium.review01_1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.java.util.BaseClass;
import com.java.util.Exceptions;

public class TeacherTask {

	public static void main(String[] args) {
		WebDriver driver = BaseClass.setUp();
		WebElement element = driver.findElement(By.id("searchDropdownBox"));
		Select selectDD = new Select(element);
		List<WebElement> options = selectDD.getOptions();
		
		for (WebElement option : options) {
			String text = option.getText();
			System.out.println(text);
		}
		selectDD.selectByVisibleText("Books");
		WebElement searchTxtBox = driver.findElement(By.id("twotabsearchtextbox"));
		searchTxtBox.sendKeys("Harry potter");
		WebElement searchButton = driver.findElement(By.xpath("//input[@type='submit'][@class='nav-input']"));
		searchButton.submit();
		
		List<WebElement> BookSeriesCheckBoxes = driver.findElements(By.className("a-spacing-micro"));
		for (WebElement BookSeriesCheckBox : BookSeriesCheckBoxes) {
			String checkBoxTxt = BookSeriesCheckBox.getText();
			if(checkBoxTxt.equals("Unofficial Cookbook") && !BookSeriesCheckBox.isSelected()) {
				BookSeriesCheckBox.click();
				break;
			}
		}
		
//		Exceptions.sleep(2000);
		BaseClass.tearDown();
	}

}
