package com.selenium.review02;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTablePractice {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://testingpool.com/data-types-in-java/");

		List<WebElement> rows = driver.findElements(By.xpath("//div[contains(@class,'su-table')]/table/tbody/tr"));
		int numberRows = rows.size();
		System.out.println("Total row number is " + numberRows);

		List<WebElement> cols = driver
				.findElements(By.xpath("//div[contains(@class,'su-table')]/table/tbody/tr[1]/td"));
		int colNumber = cols.size();
		System.out.println("Total number of cols is " + colNumber);

		//extracting cell data
		for (int i = 1; i <= rows.size(); i++) {
			for (int j = 1; j <= cols.size(); j++) {
				WebElement cellData = driver.findElement(
						By.xpath("//div[contains(@class,'su-table')]/table/tbody/tr[" + i + "]/td[" + j + "]"));
				String cellDataTxt = cellData.getText();
				// System.out.print(cellDataTxt+" ");
				if (j == 2) {
					System.out.println(cellDataTxt);
				}

			}

		}

	}

}
