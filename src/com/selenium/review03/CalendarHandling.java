package com.selenium.review03;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;

import com.java.util.CommonMethods;

public class CalendarHandling extends CommonMethods {

	public static void main(String[] args) throws IOException {
		System.setProperty(ChromeDriverService.CHROME_DRIVER_LOG_PROPERTY, "true");
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver");
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/");

		WebElement datePicker = driver.findElement(By.xpath("//a[text()='Datepicker']"));
		sleep(2);
		datePicker.click();
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		sleep(2);
		WebElement calendar = driver.findElement(By.id("datepicker"));
		click(calendar);

		String departMonth = "August 2020";

		while (true) {
			WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
			String monthTxt = driver
					.findElement(By.xpath("//div[@id='ui-datepicker-div']/div/div[@class='ui-datepicker-title']"))
					.getText();
			if (!monthTxt.equals(departMonth)) {
				nextButton.click();
			} else {
				List<WebElement> dateClasendar = driver
						.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
				selectCalendarDate(dateClasendar, "10");
				break;
			}
		}

		driver.switchTo().defaultContent();

		TakesScreenshot ts = (TakesScreenshot) driver;
		File file = ts.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(file, new File("screenshots/Pictures/calendar.png"));

	}

}
