package com.selenium.review01;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.java.util.BaseClass;
import com.java.util.Exceptions;

public class SeleniumReviewTask2 {

	public static void main(String[] args) {

		WebDriver driver = BaseClass.setUp();
		
		boolean flag = driver.findElement(By.xpath("//button[@id='u_0_13']")).isDisplayed();
		WebElement element= driver.findElement(By.xpath("//button[@id='u_0_13']"));
		String text = element.getAttribute("name");
		System.out.println(text);
		if(flag) 
			System.out.println(text+" is Displayed");
		else
			System.err.println(text+" is NOT Displayed");
		
		
		driver.findElement(By.xpath("//input[@id='u_0_m']")).sendKeys("John");
		driver.findElement(By.xpath("//input[@id='u_0_o']")).sendKeys("Smith");
		driver.findElement(By.xpath("//input[@id='u_0_r']")).sendKeys("234-233-4343");
		driver.findElement(By.cssSelector("input[autocomplete='new-password']")).sendKeys("JohnSmith");
		
		Exceptions.sleep(1000);
		WebElement month = driver.findElement(By.cssSelector("select[id='month']"));
		Select smonth = new Select(month);
		List<WebElement> monthList = smonth.getOptions();
		System.out.println("all number of month "+ monthList.size());
		for (WebElement mon : monthList) {
			String mtext = mon.getText();
			//System.out.println(mtext);
			if(mtext.equals("Nov")) {
				mon.click();
				String mmetxt = mon.getText();
				if(mmetxt.equals("Nov"))
					System.out.println("November is displayed,test Case Passed");
				else
					System.err.println("November is NOT displaed,test Case Failed");
			}
		}
		System.out.println("-------------------------------");
		Exceptions.sleep(1000);
		WebElement day = driver.findElement(By.cssSelector("select[id='day']"));
		Select sday = new Select(day);
		List<WebElement> dayList = sday.getOptions();
		System.out.println("all number of day "+ dayList.size());
		for (WebElement d : dayList) {
			String dtext = d.getText();
			//System.out.println(dtext);
			if(dtext.equals("9")) {
				d.click();
				String ddetxt = d.getText();
				if(ddetxt.equals("9"))
					System.out.println("Number 9 is displayed,test Case Passed");
				else
					System.err.println("Number 9 is NOT displaed,test Case Failed");
			}
		}
		System.out.println("====================================");
		Exceptions.sleep(1000);
		WebElement year = driver.findElement(By.cssSelector("select[id='year']"));
		Select syear = new Select(year);
		List<WebElement> options = syear.getOptions();
		System.out.println("all number of year "+ options.size());
		for (WebElement yea : options) {
			String ytxt = yea.getText();
			//System.out.println(ytxt);
			if(ytxt.equals("1997")) {
				yea.click();
				String yytxt = yea.getText();
				if(yytxt.equals("1997"))
					System.out.println("Number 1997 is displayed,test Case Passed");
				else
					System.err.println("Number 1997 is NOt displayed,test Case Failed");

			}
		}
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		List<WebElement> gender = driver.findElements(By.cssSelector("input[name='sex']"));
		System.out.println("size of gender "+gender.size());
		for (WebElement gen : gender) {
			if(gen.isEnabled()) {
				String value = gen.getAttribute("value");
				System.out.println(value);
				if(value.equals("2")) {
					gen.click();
					System.out.println("Male checkbox was selected,Test case Passed");
					break;
				}
			}
		}
		
		driver.findElement(By.cssSelector("button[id='u_0_13']")).click();;
		
		Exceptions.sleep(5000);
		BaseClass.tearDown();
		
	}

}
