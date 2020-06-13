package com.selenium.review03;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.java.util.CommonMethods;

public class CalendarDelta extends CommonMethods {

	public static void main(String[] args) {

		setUp();

		WebElement calendarClick = driver.findElement(By.xpath("//span[@class='calenderDepartSpan']"));
		click(calendarClick);

		String actualMonth = "September";

		while (true) {
			String departMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-0']")).getText();
			WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
			if (!departMonth.equals(actualMonth)) {
				sleep(1);
				nextButton.click();
			} else {	
				break;	
			}

		}
		
		List<WebElement> tableDates = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-0']/tr/td"));
		for (WebElement oneDay : tableDates) {
			String dayTxt = oneDay.getText();
			if(dayTxt.equals("12")) {
				oneDay.click();
				break;
			}
		}
		
		WebElement doneButton  = driver.findElement(By.xpath("//button[text()='done']"));
		waitAndClick(doneButton);
		
		
		System.out.println("-------------return part------------------");
		
		driver.findElement(By.xpath("//span[text()='Return']")).click();
		
		String actualValue = "December";

		while (true) {
			String departMonth = driver.findElement(By.xpath("//span[@class='dl-datepicker-month-1']")).getText();
			WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
			if (!departMonth.equals(actualValue)) {
				sleep(1);
				nextButton.click();
			} else {	
				break;	
			}

		}
		
		List<WebElement> table = driver.findElements(By.xpath("//tbody[@class='dl-datepicker-tbody-1']/tr/td"));
		for (WebElement oneDay : table) {
			String dayTxt = oneDay.getText();
			if(dayTxt.equals("15")) {
				oneDay.click();
				break;
			}
		}
		

	    doneButton  = driver.findElement(By.xpath("//button[text()='done']"));
		waitAndClick(doneButton);
		
		
		
		
		
		
		
		
		
		

	}

}
